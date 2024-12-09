package com.ifoodclone.IFood.Clone.dto.user;

import com.ifoodclone.IFood.Clone.domain.user.User;
import com.ifoodclone.IFood.Clone.dto.address.AddressDTO;

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
