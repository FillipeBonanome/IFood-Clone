package com.ifoodclone.IFood.Clone.dto;

import com.ifoodclone.IFood.Clone.user.AddressData;
import com.ifoodclone.IFood.Clone.user.UserType;
import com.ifoodclone.IFood.Clone.validation.age.ValidAge;
import com.ifoodclone.IFood.Clone.validation.cpf.ValidCPF;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record UserDTO(
        @NotBlank
        @Size(min = 4, max = 32, message = "Your name must be at least 4 characters and must not surpass 32 characters.")
        String nome,

        @NotBlank
        @Email
        @Size(max = 64, message = "Your email must not surpass 64 characters.")
        String email,

        @NotBlank
        @ValidCPF
        String CPF,

        @NotBlank
        @Size(min = 10, max = 11, message = "Your Phone Number must have between 10 and 11 digits")
        String phoneNumber,

        @NotNull
        @ValidAge
        LocalDateTime birthday,

        @NotNull
        @Valid
        AddressData address,

        @NotNull
        UserType usertype,

        @NotBlank
        @Pattern(regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9]).{8,}$", message = "Your Password must have at least a letter, a number and at least 8 digits")
        String password) {
}
