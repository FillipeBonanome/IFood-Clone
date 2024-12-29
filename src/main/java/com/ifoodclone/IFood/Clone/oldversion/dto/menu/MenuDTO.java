package com.ifoodclone.IFood.Clone.oldversion.dto.menu;

import com.ifoodclone.IFood.Clone.oldversion.domain.menu.Menu;
import com.ifoodclone.IFood.Clone.oldversion.dto.menuitem.MenuItemListDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MenuDTO(
        @NotNull
        Long id,

        @NotBlank
        String name,

        @Valid
        List<MenuItemListDTO> menuItems,

        @NotBlank
        Long restaurantId
        ) {
        public MenuDTO(Menu savedMenu) {
                this(savedMenu.getId(), savedMenu.getName(), savedMenu.getItems().stream().map(MenuItemListDTO::new).toList(), savedMenu.getRestaurant().getId());
        }
}
