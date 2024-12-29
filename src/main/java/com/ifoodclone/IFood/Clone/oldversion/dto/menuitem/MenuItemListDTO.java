package com.ifoodclone.IFood.Clone.oldversion.dto.menuitem;

import com.ifoodclone.IFood.Clone.oldversion.domain.menuitem.MenuItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuItemListDTO(
        @NotNull
        Long id,

        @NotBlank
        String name,

        @NotNull
        float price,

        @NotBlank
        String description
) {

    public MenuItemListDTO(MenuItem menuItem) {
        this(menuItem.getId(), menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
    }

    public MenuItemListDTO(MenuItemDTO menuItem) {
        this(menuItem.id(), menuItem.name(), menuItem.price(), menuItem.description());
    }
}
