package com.ifoodclone.IFood.Clone.dto;

import com.ifoodclone.IFood.Clone.user.AddressData;
import com.ifoodclone.IFood.Clone.user.User;

public record UserListDTO(
        String name,
        String email,
        String phoneNumber,
        AddressData addressData
) {

    public UserListDTO(User user) {
        this(user.getName(), user.getEmail(), user.getPhoneNumber(), new AddressData(user.getAddress()));
    }

}
