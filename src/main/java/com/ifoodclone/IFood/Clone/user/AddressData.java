package com.ifoodclone.IFood.Clone.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressData(
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
}
