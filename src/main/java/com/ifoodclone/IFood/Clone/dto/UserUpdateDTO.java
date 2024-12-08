package com.ifoodclone.IFood.Clone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserUpdateDTO(
        @NotNull
        Long id,

        @Size(min = 4, max = 32, message = "Your name must be at least 4 characters and must not surpass 32 characters.")
        String name,

        @Pattern(regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9]).{8,}$", message = "Your Password must have at least a letter, a number and at least 8 digits")
        String password) {
}
