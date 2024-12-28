package com.ifoodclone.IFood.Clone.dto.orderitem;

import jakarta.validation.constraints.NotNull;

public record OrderItemRegisterDTO(
        @NotNull Long menuItemId,
        @NotNull Long quantity,
        @NotNull Long orderId
) {
}
