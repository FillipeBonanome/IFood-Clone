package com.ifoodclone.IFood.Clone.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAllByActiveTrue(Pageable pageable);

    UserDetails findByEmail(String email);
}
