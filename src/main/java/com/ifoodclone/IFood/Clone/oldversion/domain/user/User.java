package com.ifoodclone.IFood.Clone.oldversion.domain.user;

import com.ifoodclone.IFood.Clone.oldversion.domain.address.Address;
import com.ifoodclone.IFood.Clone.oldversion.domain.order.Order;
import com.ifoodclone.IFood.Clone.oldversion.dto.user.UserDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.user.UserRegisterDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.user.UserUpdateDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public User(UserRegisterDTO user) {
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
