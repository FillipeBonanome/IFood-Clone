package com.ifoodclone.IFood.Clone.oldversion.controller;

import com.ifoodclone.IFood.Clone.oldversion.domain.user.User;
import com.ifoodclone.IFood.Clone.oldversion.dto.user.*;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.UserException;
import com.ifoodclone.IFood.Clone.oldversion.repository.UserRepository;
import com.ifoodclone.IFood.Clone.oldversion.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDTO> getUserById(@PathVariable Long id) {
        var user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new UserDetailDTO(user));
    }

    @GetMapping
    public ResponseEntity<Page<UserListDTO>> getUsers(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = userRepository.findAllByActiveTrue(pageable).map(UserListDTO::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserRegisterDTO user, UriComponentsBuilder uriBuilder) throws UserException {
        var newUser = this.userService.registerUser(user);
        return ResponseEntity.created(uriBuilder.path("/user/{id}").buildAndExpand(newUser.id()).toUri()).
                body(newUser);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserDetailDTO> updateUser(@RequestBody @Valid UserUpdateDTO data) {
        var user = this.userService.updateUser(data);
        return ResponseEntity.ok(new UserDetailDTO(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<UserDetailDTO> restoreUser(@PathVariable Long id) {
        User user = this.userService.restoreUser(id);
        return ResponseEntity.ok(new UserDetailDTO(user));
    }

}
