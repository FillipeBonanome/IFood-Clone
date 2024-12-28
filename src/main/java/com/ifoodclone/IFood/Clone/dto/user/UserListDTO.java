package com.ifoodclone.IFood.Clone.dto.user;

import com.ifoodclone.IFood.Clone.domain.user.User;
import com.ifoodclone.IFood.Clone.dto.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserListDTO(
        @NotBlank
        @Size(min = 4, max = 32, message = "Your name must be at least 4 characters and must not surpass 32 characters.")
        String name,

        @NotBlank
        @Email
        @Size(max = 64, message = "Your email must not surpass 64 characters.")
        String email,

        @NotBlank
        @Size(min = 10, max = 11, message = "Your Phone Number must have between 10 and 11 digits")
        String phoneNumber,

        @Valid
        AddressDTO address
) {

    public UserListDTO(User user) {
        this(user.getName(), user.getEmail(), user.getPhoneNumber(), new AddressDTO(user.getAddress()));
    }

}
