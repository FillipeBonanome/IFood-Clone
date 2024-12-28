package com.ifoodclone.IFood.Clone.dto.orderitem;

import com.ifoodclone.IFood.Clone.domain.orderitem.OrderItem;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OrderItemDTO(
        @NotNull Long id,
        @NotNull Long menuItemId,
        @NotNull Long quantity,
        @NotNull Long orderId
        ) {
    public OrderItemDTO(OrderItem orderItem) {
        this(orderItem.getId(), orderItem.getMenuItem().getId(), orderItem.getQuantity(), orderItem.getOrder().getId());
    }
}
