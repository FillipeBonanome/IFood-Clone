package com.ifoodclone.IFood.Clone.user;

import com.ifoodclone.IFood.Clone.oldversion.infra.exception.UserException;
import com.ifoodclone.IFood.Clone.oldversion.validation.age.AgeValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class UserAgeTest {

    private final AgeValidator validator = new AgeValidator();

    @Test
    @DisplayName("Test with user older than 12 years")
    void test01() {
        var birthday = LocalDateTime.now().minusYears(13);
        Assertions.assertDoesNotThrow(() -> validator.isValid(birthday));
    }

    @Test
    @DisplayName("Test with user with exact 12 years")
    void test02() {
        var birthday = LocalDateTime.now().minusYears(12);
        Assertions.assertDoesNotThrow(() -> validator.isValid(birthday));
    }

    @Test
    @DisplayName("Test with user with exact 11 years")
    void test03() {
        var birthday = LocalDateTime.now().minusYears(11);
        Assertions.assertThrows(UserException.class, () -> validator.isValid(birthday));
    }

    @Test
    @DisplayName("Test with user with almost 12 years")
    void test04() {
        var birthday = LocalDateTime.now().minusYears(11).minusMonths(11).minusHours(23);
        Assertions.assertThrows(UserException.class, () -> validator.isValid(birthday));
    }

    @Test
    @DisplayName("Test with a time traveler")
    void test05() {
        var birthday = LocalDateTime.now().plusYears(32);
        Assertions.assertThrows(UserException.class, () -> validator.isValid(birthday));
    }

}
