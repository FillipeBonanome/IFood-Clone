package com.ifoodclone.IFood.Clone.dto.user;

import com.ifoodclone.IFood.Clone.domain.user.User;
import com.ifoodclone.IFood.Clone.domain.user.UserType;
import com.ifoodclone.IFood.Clone.dto.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record UserRegisterDTO(
        @NotBlank
        @Size(min = 4, max = 32, message = "Your name must be at least 4 characters and must not surpass 32 characters.")
        String name,

        @NotBlank
        @Email
        @Size(max = 64, message = "Your email must not surpass 64 characters.")
        String email,

        @NotBlank
        String CPF,

        @NotBlank
        @Size(min = 10, max = 11, message = "Your Phone Number must have between 10 and 11 digits")
        String phoneNumber,

        @NotNull
        LocalDateTime birthday,

        @NotNull
        @Valid
        AddressDTO address,

        @NotNull
        UserType usertype,

        @NotBlank
        @Pattern(regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9]).{8,}$", message = "Your Password must have at least a letter, a number and at least 8 digits")
        String password
) {
    public UserRegisterDTO(User newUser) {
        this(newUser.getName(), newUser.getEmail(), newUser.getCPF(),
                newUser.getPhoneNumber(), newUser.getBirthday(), new AddressDTO(newUser.getAddress()), newUser.getUsertype(), newUser.getPassword());
    }

}
