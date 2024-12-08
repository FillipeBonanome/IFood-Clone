package com.ifoodclone.IFood.Clone.dto;

import com.ifoodclone.IFood.Clone.user.AddressDTO;
import com.ifoodclone.IFood.Clone.user.User;
import com.ifoodclone.IFood.Clone.user.UserType;
import com.ifoodclone.IFood.Clone.validation.age.ValidAge;
import com.ifoodclone.IFood.Clone.validation.cpf.ValidCPF;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UserDetailDTO(@NotNull
                            Long id,

                            @NotBlank
                            @Size(min = 4, max = 32, message = "Your name must be at least 4 characters and must not surpass 32 characters.")
                            String name,

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
                            AddressDTO address,

                            @NotNull
                            UserType usertype) {

    public UserDetailDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getCPF(), user.getPhoneNumber(), user.getBirthday(), new AddressDTO(user.getAddress()), user.getUsertype());
    }
}
