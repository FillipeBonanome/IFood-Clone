package com.ifoodclone.IFood.Clone.controller;

import com.ifoodclone.IFood.Clone.dto.UserDTO;
import com.ifoodclone.IFood.Clone.dto.UserListDTO;
import com.ifoodclone.IFood.Clone.dto.UserUpdateDTO;
import com.ifoodclone.IFood.Clone.user.User;
import com.ifoodclone.IFood.Clone.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //TODO
    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id) {
        return id;
    }

    //TODO
    @GetMapping
    public Page<UserListDTO> getUsers(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return userRepository.findAllByActiveTrue(pageable).map(UserListDTO::new);
    }

    @PostMapping
    @Transactional
    public void registerUser(@RequestBody @Valid UserDTO user) { userRepository.save(new User(user));}

    @PutMapping
    @Transactional
    public void updateUser(@RequestBody @Valid UserUpdateDTO data) {
            var user = userRepository.getReferenceById(data.id());
            user.updateInfo(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteUser(@PathVariable Long id) {
        var user = userRepository.getReferenceById(id);
        user.delete();
    }

    @PatchMapping("/{id}")
    @Transactional
    public void restoreUser(@PathVariable Long id) {
        var user = userRepository.getReferenceById(id);
        user.restore();
    }

}
