package com.ifoodclone.IFood.Clone.user;

import com.ifoodclone.IFood.Clone.address.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        String number,

        @NotBlank
        String street,

        @NotBlank
        String district,

        @NotBlank
        String city,

        @NotBlank
        String state,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String code
) {
        public AddressDTO(Address address) {
                this(address.getNumber(), address.getStreet(), address.getDistrict(), address.getCity(), address.getState(), address.getCode());
        }
}
