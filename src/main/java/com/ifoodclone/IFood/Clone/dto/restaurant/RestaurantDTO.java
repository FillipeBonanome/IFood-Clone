package com.ifoodclone.IFood.Clone.dto.restaurant;

import com.ifoodclone.IFood.Clone.domain.restaurant.Restaurant;
import com.ifoodclone.IFood.Clone.dto.address.AddressDTO;
import com.ifoodclone.IFood.Clone.validation.cnpj.ValidCNPJ;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
        @ValidCNPJ
        String CNPJ
        ) {
        public RestaurantDTO(Restaurant restaurant) {
                this(restaurant.getId(), restaurant.getOwner().getId(), restaurant.getName(), new AddressDTO(restaurant.getAddress()),
                        restaurant.getPhoneNumber(), restaurant.getCategory(), restaurant.getDescription(), restaurant.getCNPJ());
        }
}
