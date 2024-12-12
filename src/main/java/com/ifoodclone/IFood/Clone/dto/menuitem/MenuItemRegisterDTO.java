package com.ifoodclone.IFood.Clone.dto.menuitem;

import com.ifoodclone.IFood.Clone.domain.menuitem.MenuItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuItemRegisterDTO(
        @NotBlank
        String name,

        @NotNull
        float price,

        @NotBlank
        String description,

        @NotNull
        Long menuId
) {

    public MenuItemRegisterDTO(MenuItem menuItem) {
        this(menuItem.getName(), menuItem.getPrice(), menuItem.getDescription(), menuItem.getMenu().getId());
    }

}
