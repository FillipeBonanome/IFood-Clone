package com.ifoodclone.IFood.Clone.oldversion.controller;

import com.ifoodclone.IFood.Clone.oldversion.dto.order.OrderDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.order.OrderRegisterDTO;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.OrderException;
import com.ifoodclone.IFood.Clone.oldversion.repository.OrderRepository;
import com.ifoodclone.IFood.Clone.oldversion.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        var order = this.orderRepository.getReferenceById(id);
        return ResponseEntity.ok(new OrderDTO(order));
    }

    @GetMapping
    public ResponseEntity<Page<OrderDTO>> getOrders(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = orderRepository.findAll(pageable).map(OrderDTO::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> registerOrder(@RequestBody @Valid OrderRegisterDTO order, UriComponentsBuilder uriBuilder) throws OrderException {
        var newOrder = orderService.registerOrder(order);
        return ResponseEntity.created(uriBuilder.path("/order/{id}").buildAndExpand(newOrder.id()).toUri()).
                body(newOrder);
    }

}
