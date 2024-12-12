package com.ifoodclone.IFood.Clone.dto.menu;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuRegisterDTO(
        @NotBlank
        String name,
        @NotNull
        Long restaurantId
) {
}