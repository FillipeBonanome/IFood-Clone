package com.ifoodclone.IFood.Clone.dto.menu;

import com.ifoodclone.IFood.Clone.domain.menu.Menu;
import com.ifoodclone.IFood.Clone.domain.menuitem.MenuItem;
import com.ifoodclone.IFood.Clone.domain.restaurant.Restaurant;
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
        List<MenuItem> menuItems,

        @NotBlank
        Restaurant restaurant
        ) {
        public MenuDTO(Menu savedMenu) {
                this(savedMenu.getId(), savedMenu.getName(), savedMenu.getItems(), savedMenu.getRestaurant());
        }
}
