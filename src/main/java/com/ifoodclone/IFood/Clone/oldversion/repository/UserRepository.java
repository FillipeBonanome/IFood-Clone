package com.ifoodclone.IFood.Clone.oldversion.repository;

import com.ifoodclone.IFood.Clone.oldversion.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getReferenceByIdAndActiveTrue(Long id);
    Page<User> findAllByActiveTrue(Pageable pageable);
    Optional<User> findByEmail(String email);
}
