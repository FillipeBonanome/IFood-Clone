package com.ifoodclone.IFood.Clone.controller;

import com.ifoodclone.IFood.Clone.dto.UserDTO;
import com.ifoodclone.IFood.Clone.dto.UserDetailDTO;
import com.ifoodclone.IFood.Clone.dto.UserListDTO;
import com.ifoodclone.IFood.Clone.dto.UserUpdateDTO;
import com.ifoodclone.IFood.Clone.user.User;
import com.ifoodclone.IFood.Clone.user.UserRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

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
    public ResponseEntity<UserDetailDTO> registerUser(@RequestBody @Valid UserDTO user, UriComponentsBuilder uriBuilder) {
        var newUser = new User(user);
        userRepository.save(newUser);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailDTO(newUser));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserDetailDTO> updateUser(@RequestBody @Valid UserUpdateDTO data) {
            var user = userRepository.getReferenceById(data.id());
            user.updateInfo(data);

            return ResponseEntity.ok(new UserDetailDTO(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        var user = userRepository.getReferenceById(id);
        user.delete();
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<UserDetailDTO> restoreUser(@PathVariable Long id) {
        var user = userRepository.getReferenceById(id);
        user.restore();

        return ResponseEntity.ok(new UserDetailDTO(user));
    }

}
