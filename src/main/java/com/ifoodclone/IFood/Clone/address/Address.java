package com.ifoodclone.IFood.Clone.address;

import com.ifoodclone.IFood.Clone.user.AddressData;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    private String number;
    private String street;
    private String district;
    private String city;
    private String state;
    private String code;

    public Address(AddressData address) {
        this.number = address.number();
        this.street = address.street();
        this.district = address.district();
        this.city = address.city();
        this.state = address.state();
        this.code = address.code();
    }
}
