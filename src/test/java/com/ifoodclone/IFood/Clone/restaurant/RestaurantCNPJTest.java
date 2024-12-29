package com.ifoodclone.IFood.Clone.restaurant;

import com.ifoodclone.IFood.Clone.oldversion.infra.exception.RestaurantException;
import com.ifoodclone.IFood.Clone.oldversion.validation.cnpj.CNPJValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestaurantCNPJTest {

    private final CNPJValidator validator = new CNPJValidator();

    @Test
    @DisplayName("Test with a valid CNPJ and no formatting")
    void test01() {
        var cnpj = "86067922000131";
        Assertions.assertDoesNotThrow(() -> validator.isValid(cnpj));
    }

    @Test
    @DisplayName("Test with a valid CNPJ and formatting")
    void test02() {
        var cnpj = "71.022.332/0001-15";
        Assertions.assertDoesNotThrow(() -> validator.isValid(cnpj));
    }

    @Test
    @DisplayName("Test with an invalid CNPJ digits and correct formatting")
    void test03() {
        var cnpj = "08.882.943/0001-04";
        Assertions.assertThrows(RestaurantException.class, () -> validator.isValid(cnpj));
    }

    @Test
    @DisplayName("Test with an invalid CNPJ digits and no formatting")
    void test04() {
        var cnpj = "27670317000192";
        Assertions.assertThrows(RestaurantException.class, () -> validator.isValid(cnpj));
    }

    @Test
    @DisplayName("Test with a letter")
    void test05() {
        var cnpj = "27670317b00192";
        Assertions.assertThrows(RestaurantException.class, () -> validator.isValid(cnpj));
    }
}
