package com.ifoodclone.IFood.Clone.dto.menuitem;

import com.ifoodclone.IFood.Clone.domain.menu.Menu;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuItemDTO(
        @NotNull
        Long id,

        @NotBlank
        String name,

        @NotNull
        Long price,

        @NotBlank
        String description,

        @Valid
        Menu menu

) {
}
