package com.ifoodclone.IFood.Clone.user;


import com.ifoodclone.IFood.Clone.address.Address;
import com.ifoodclone.IFood.Clone.dto.UserDTO;
import com.ifoodclone.IFood.Clone.dto.UserUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "users")
@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String CPF;
    private String phoneNumber;
    private LocalDateTime birthday;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private UserType usertype;
    private String password;

    private Boolean active;

    public User(UserDTO user) {
        this.active = true;
        this.name = user.name();
        this.email = user.email();
        this.CPF = user.CPF();
        this.phoneNumber = user.phoneNumber();
        this.birthday = user.birthday();
        this.address = new Address(user.address());
        this.usertype = user.usertype();
        this.password = user.password();
    }

    public void updateInfo(UserUpdateDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }

        if (data.password() != null) {
            this.password = data.password();
        }
    }

    public void delete() {
        this.active = false;
    }

    public void restore() {
        this.active = true;
    }

}
