package com.ifoodclone.IFood.Clone.user;


import com.ifoodclone.IFood.Clone.address.Address;
import com.ifoodclone.IFood.Clone.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "users")
@Entity(name = "User")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String CPF;
    private String phoneNumber;
    private LocalDateTime birthday;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private UserType usertype;
    private String password;

    public User(UserDTO user) {
        this.nome = user.nome();
        this.email = user.email();
        this.CPF = user.CPF();
        this.phoneNumber = user.phoneNumber();
        this.birthday = user.birthday();
        this.address = new Address(user.address());
        this.usertype = user.usertype();
        this.password = user.password();
    }
}
