package com.ifoodclone.IFood.Clone.dto.order;

import jakarta.validation.constraints.NotNull;

public record OrderRegisterDTO(
        @NotNull Long ownerId
) {
}
