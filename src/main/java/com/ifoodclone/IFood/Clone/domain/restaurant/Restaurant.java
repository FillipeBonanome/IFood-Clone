package com.ifoodclone.IFood.Clone.domain.restaurant;

import com.ifoodclone.IFood.Clone.domain.address.Address;
import com.ifoodclone.IFood.Clone.domain.user.User;
import com.ifoodclone.IFood.Clone.dto.restaurant.RestaurantDTO;
import com.ifoodclone.IFood.Clone.dto.restaurant.RestaurantRegisterDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Restaurant")
@Table(name = "restaurants")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    @Embedded
    private Address address;

    private String phoneNumber;
    private String category;
    private String description;
    private String CNPJ;
}
