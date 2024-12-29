package com.ifoodclone.IFood.Clone.oldversion.service;

import com.ifoodclone.IFood.Clone.oldversion.domain.menuitem.MenuItem;
import com.ifoodclone.IFood.Clone.oldversion.domain.order.Order;
import com.ifoodclone.IFood.Clone.oldversion.domain.orderitem.OrderItem;
import com.ifoodclone.IFood.Clone.oldversion.dto.orderitem.OrderItemDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.orderitem.OrderItemRegisterDTO;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.OrderItemException;
import com.ifoodclone.IFood.Clone.oldversion.repository.MenuItemRepository;
import com.ifoodclone.IFood.Clone.oldversion.repository.OrderItemRepository;
import com.ifoodclone.IFood.Clone.oldversion.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public OrderItemDTO registerOrderItem(OrderItemRegisterDTO orderItem) throws OrderItemException {
        var order = getOrderById(orderItem.orderId());
        var menuItem = getMenuItemById(orderItem.menuItemId());
        var newOrderItem = new OrderItem(null, menuItem, orderItem.quantity(), order);
        var savedOrderItem = orderItemRepository.save(newOrderItem);
        return new OrderItemDTO(savedOrderItem);
    }

    public Order getOrderById(Long id) throws OrderItemException {
        var order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new OrderItemException("Order not found");
        }
        return order.get();
    }

    public MenuItem getMenuItemById(Long id) throws OrderItemException {
        var menuItem = menuItemRepository.findById(id);
        if (menuItem.isEmpty()) {
            throw new OrderItemException("Menu Item not found");
        }
        return menuItem.get();
    }
}
