package com.ifoodclone.IFood.Clone.oldversion.dto.token;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(
        @NotBlank
        String token) {
}
