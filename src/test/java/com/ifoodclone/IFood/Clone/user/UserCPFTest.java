package com.ifoodclone.IFood.Clone.user;

import com.ifoodclone.IFood.Clone.oldversion.infra.exception.UserException;
import com.ifoodclone.IFood.Clone.oldversion.validation.cpf.CPFValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserCPFTest {

    private final CPFValidator validator = new CPFValidator();

    @Test
    @DisplayName("First test with a valid CPF and no formatting")
    void test01() {
        var cpf = "00214487016";
        Assertions.assertDoesNotThrow(() -> validator.isValid(cpf), "No exception thrown");
    }

    @Test
    @DisplayName("Second test with a valid CPF and formatting")
    void test02() {
        var cpf = "651.476.220-47";
        Assertions.assertDoesNotThrow(() -> validator.isValid(cpf), "No exception thrown");
    }

    @Test
    @DisplayName("Test with incorrect number of digits")
    void test03() {
        var cpf = "651.476.220-4";
        Assertions.assertThrows(UserException.class, () -> validator.isValid(cpf));
    }

    @Test
    @DisplayName("Test with no digits")
    void test04() {
        var cpf = "";
        Assertions.assertThrows(UserException.class, () -> validator.isValid(cpf));
    }

    @Test
    @DisplayName("Test with a letter")
    void test05() {
        var cpf = "65a.476.220-47";
        Assertions.assertThrows(UserException.class, () -> validator.isValid(cpf));
    }

}
