package com.ifoodclone.IFood.Clone.dto.menuitem;

import com.ifoodclone.IFood.Clone.domain.menuitem.MenuItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuItemDTO(
        @NotNull
        Long id,

        @NotBlank
        String name,

        @NotNull
        float price,

        @NotBlank
        String description,

        @NotNull
        Long menuId

) {
    public MenuItemDTO(MenuItem menuItem) {
        this(menuItem.getId(), menuItem.getName(), menuItem.getPrice(), menuItem.getDescription(), menuItem.getMenu().getId());
    }
}
