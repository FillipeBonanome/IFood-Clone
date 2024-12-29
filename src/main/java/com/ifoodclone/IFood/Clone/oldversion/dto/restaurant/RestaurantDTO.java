package com.ifoodclone.IFood.Clone.oldversion.dto.restaurant;

import com.ifoodclone.IFood.Clone.oldversion.domain.restaurant.Restaurant;
import com.ifoodclone.IFood.Clone.oldversion.dto.address.AddressDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.menu.MenuDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record RestaurantDTO(
        @NotNull
        Long id,

        @NotNull
        Long ownerId,

        @NotBlank
        String name,

        @Valid
        AddressDTO address,

        @NotBlank
        @Size(min = 10, max = 11, message = "Your Phone Number must have between 10 and 11 digits")
        String phoneNumber,

        @NotBlank
        String category,

        @NotBlank
        String description,

        @NotBlank
        String CNPJ,

        @Valid
        List<MenuDTO> menuList

        ) {
        public RestaurantDTO(Restaurant restaurant) {
                this(restaurant.getId(), restaurant.getOwner().getId(), restaurant.getName(), new AddressDTO(restaurant.getAddress()),
                        restaurant.getPhoneNumber(), restaurant.getCategory(), restaurant.getDescription(), restaurant.getCNPJ(), restaurant.getMenus().stream().map(MenuDTO::new).toList());
        }
}
