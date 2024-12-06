package com.ifoodclone.IFood.Clone.controller;

import com.ifoodclone.IFood.Clone.dto.UserDTO;
import com.ifoodclone.IFood.Clone.user.User;
import com.ifoodclone.IFood.Clone.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    @Transactional
    public void registerUser(@RequestBody @Valid UserDTO user) {
        userRepository.save(new User(user));
    }

}
