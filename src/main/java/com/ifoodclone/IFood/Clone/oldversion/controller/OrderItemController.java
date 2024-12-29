package com.ifoodclone.IFood.Clone.oldversion.controller;

import com.ifoodclone.IFood.Clone.oldversion.dto.orderitem.OrderItemDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.orderitem.OrderItemRegisterDTO;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.MenuItemException;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.OrderItemException;
import com.ifoodclone.IFood.Clone.oldversion.repository.OrderItemRepository;
import com.ifoodclone.IFood.Clone.oldversion.service.OrderItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/order_item")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItem(@PathVariable Long id) {
        var order = orderItemRepository.getReferenceById(id);
        return ResponseEntity.ok(new OrderItemDTO(order));
    }

    @GetMapping
    public ResponseEntity<Page<OrderItemDTO>> getOrderItems(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = orderItemRepository.findAll(pageable).map(OrderItemDTO::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<OrderItemDTO> registerOrderItem(@RequestBody @Valid OrderItemRegisterDTO orderItem, UriComponentsBuilder uriBuilder) throws OrderItemException, MenuItemException {
        var newOrderItem = orderItemService.registerOrderItem(orderItem);
        return ResponseEntity.created(uriBuilder.path("/order_item/{id}").buildAndExpand(newOrderItem.id()).toUri()).
                body(newOrderItem);
    }

}
