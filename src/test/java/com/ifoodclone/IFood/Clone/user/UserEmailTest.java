package com.ifoodclone.IFood.Clone.user;

import com.ifoodclone.IFood.Clone.domain.user.User;
import com.ifoodclone.IFood.Clone.infra.exception.UserException;
import com.ifoodclone.IFood.Clone.repository.UserRepository;
import com.ifoodclone.IFood.Clone.validation.email.EmailValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserEmailTest {

    @InjectMocks
    private EmailValidator emailValidator;

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    @Test
    @DisplayName("Test if email already exists")
    public void test01() {
        String email = "email@email.com";
        BDDMockito.given(userRepository.findByEmail(email)).willReturn(Optional.of(user));
        Assertions.assertThrows(UserException.class, () -> emailValidator.isValid(email));
    }

    @Test
    @DisplayName("Test if email doesn't exist")
    public void test02() {
        String email = "email@email.com";
        BDDMockito.given(userRepository.findByEmail(email)).willReturn(Optional.empty());
        Assertions.assertDoesNotThrow(() -> emailValidator.isValid(email));
    }

}
