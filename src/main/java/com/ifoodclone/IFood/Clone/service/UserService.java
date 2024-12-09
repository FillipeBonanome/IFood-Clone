package com.ifoodclone.IFood.Clone.service;

import com.ifoodclone.IFood.Clone.domain.user.User;
import com.ifoodclone.IFood.Clone.dto.user.UserDTO;
import com.ifoodclone.IFood.Clone.dto.user.UserDetailDTO;
import com.ifoodclone.IFood.Clone.dto.user.UserUpdateDTO;
import com.ifoodclone.IFood.Clone.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserDTO registerUser(UserDTO user) {
        var newUser = new User(user);
        var encodedPassword = passwordEncoder.encode(user.password());
        newUser.setPassword(encodedPassword);
        userRepository.save(newUser);

        return new UserDTO(newUser);
    }

    public User updateUser(UserUpdateDTO data) {
        var user = userRepository.getReferenceById(data.id());
        user.updateInfo(data);
        return user;
    }

    public void deleteUser(Long id) {
        var user = userRepository.getReferenceById(id);
        user.delete();
    }

    public User restoreUser(Long id) {
        var user = userRepository.getReferenceById(id);
        user.restore();
        return user;
    }


}
