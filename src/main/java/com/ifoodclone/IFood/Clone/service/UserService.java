package com.ifoodclone.IFood.Clone.service;

import com.ifoodclone.IFood.Clone.domain.user.User;
import com.ifoodclone.IFood.Clone.dto.user.UserDTO;
import com.ifoodclone.IFood.Clone.dto.user.UserRegisterDTO;
import com.ifoodclone.IFood.Clone.dto.user.UserUpdateDTO;
import com.ifoodclone.IFood.Clone.infra.exception.UserException;
import com.ifoodclone.IFood.Clone.repository.UserRepository;
import com.ifoodclone.IFood.Clone.validation.age.AgeValidator;
import com.ifoodclone.IFood.Clone.validation.cpf.CPFValidator;
import com.ifoodclone.IFood.Clone.validation.email.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserDTO registerUser(UserRegisterDTO user) throws UserException {

        var CPFValidator = new CPFValidator();
        CPFValidator.isValid(user.CPF());

        var ageValidator = new AgeValidator();
        ageValidator.isValid(user.birthday());

        //TODO --> Look why this is bugging, userRepository is null if i use this in another clas
        verifyUniqueEmail(user);

        var newUser = new User(user);
        var encodedPassword = passwordEncoder.encode(user.password());
        newUser.setPassword(encodedPassword);
        var savedUser = userRepository.save(newUser);
        return new UserDTO(savedUser);
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

    private void verifyUniqueEmail(UserRegisterDTO user) throws UserException {
        var checkUserEmail = userRepository.findByEmail(user.email());
        if (checkUserEmail.isPresent()) {
            throw new UserException("This e-mail is already registered!");
        }
    }


}
