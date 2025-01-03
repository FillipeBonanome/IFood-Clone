package com.ifoodclone.IFood.Clone.oldversion.dto.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password) {
}
