package com.ifoodclone.IFood.Clone.service;

import com.ifoodclone.IFood.Clone.domain.order.Order;
import com.ifoodclone.IFood.Clone.domain.order.OrderStatus;
import com.ifoodclone.IFood.Clone.domain.orderitem.OrderItem;
import com.ifoodclone.IFood.Clone.domain.user.User;
import com.ifoodclone.IFood.Clone.dto.order.OrderDTO;
import com.ifoodclone.IFood.Clone.dto.order.OrderRegisterDTO;
import com.ifoodclone.IFood.Clone.infra.exception.OrderException;
import com.ifoodclone.IFood.Clone.repository.OrderRepository;
import com.ifoodclone.IFood.Clone.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public OrderDTO registerOrder(OrderRegisterDTO order) throws OrderException {
        List<OrderItem> orderItemList = new ArrayList<>();
        var user = getUserById(order.ownerId());
        var newOrder = new Order(null, orderItemList, user, OrderStatus.PENDING);
        var savedOrder = orderRepository.save(newOrder);
        return new OrderDTO(savedOrder);
    }

    public User getUserById(Long id) throws OrderException {
        var user = userRepository.getReferenceByIdAndActiveTrue(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new OrderException("User not found");
    }
}
