package com.ifoodclone.IFood.Clone.user;


import com.ifoodclone.IFood.Clone.address.Address;
import com.ifoodclone.IFood.Clone.dto.UserDTO;
import com.ifoodclone.IFood.Clone.dto.UserUpdateDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "users")
@Entity(name = "User")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true, nullable = false)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
