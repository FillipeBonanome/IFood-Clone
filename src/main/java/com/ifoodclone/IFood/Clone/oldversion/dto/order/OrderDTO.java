package com.ifoodclone.IFood.Clone.oldversion.dto.order;

import com.ifoodclone.IFood.Clone.oldversion.domain.order.Order;
import com.ifoodclone.IFood.Clone.oldversion.domain.order.OrderStatus;
import com.ifoodclone.IFood.Clone.oldversion.dto.orderitem.OrderItemDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderDTO(
        @NotNull Long id,
        @Valid List<OrderItemDTO> orderItemList,
        @NotNull Long ownerId,
        @Enumerated(EnumType.STRING) OrderStatus orderStatus
) {
    public OrderDTO(Order order) {
        this(order.getId(), order.getOrderList().stream().map(OrderItemDTO::new).toList(), order.getOwner().getId(), order.getOrderStatus());
    }
}
