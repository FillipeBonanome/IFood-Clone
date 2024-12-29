package com.ifoodclone.IFood.Clone.oldversion.validation.email;

import com.ifoodclone.IFood.Clone.oldversion.infra.exception.UserException;
import com.ifoodclone.IFood.Clone.oldversion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailValidator {

    @Autowired
    private UserRepository userRepository;

    public void isValid(String email) throws UserException {
        var checkUserEmail = userRepository.findByEmail(email);
        if (checkUserEmail.isPresent()) {
            throw new UserException("This e-mail is already registered!");
        }
    }

}
