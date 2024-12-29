package com.ifoodclone.IFood.Clone.oldversion.dto.orderitem;

import com.ifoodclone.IFood.Clone.oldversion.domain.orderitem.OrderItem;
import jakarta.validation.constraints.NotNull;

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
