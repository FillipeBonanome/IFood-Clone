package com.ifoodclone.IFood.Clone.dto;

import com.ifoodclone.IFood.Clone.user.AddressDTO;
import com.ifoodclone.IFood.Clone.user.User;

public record UserListDTO(
        String name,
        String email,
        String phoneNumber,
        AddressDTO addressDTO
) {

    public UserListDTO(User user) {
        this(user.getName(), user.getEmail(), user.getPhoneNumber(), new AddressDTO(user.getAddress()));
    }

}
