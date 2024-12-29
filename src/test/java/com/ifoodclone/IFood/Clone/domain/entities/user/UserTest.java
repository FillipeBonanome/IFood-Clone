package com.ifoodclone.IFood.Clone.domain.entities.user;

import com.ifoodclone.IFood.Clone.oldversion.domain.address.Address;
import com.ifoodclone.IFood.Clone.oldversion.domain.order.Order;
import com.ifoodclone.IFood.Clone.oldversion.domain.user.UserType;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserTest {

    private Address address = new Address("123", "street", "district", "city", "state", "code");
    private List<Order> order = new ArrayList<>();

    @Test
    @DisplayName("Test for invalid CPF format 01")
    public void invalidFormat01() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "123-456-789-123", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));
    }

    @Test
    @DisplayName("Test for invalid CPF format 02")
    public void invalidFormat02() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for invalid CPF format 03")
    public void invalidFormat03() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "1234", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for invalid CPF format 04")
    public void invalidFormat04() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "123.456.789-1A", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for invalid CPF format 05")
    public void invalidFormat05() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "123456789123456", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 01")
    public void validFormat01() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "011.139.270-54", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 02")
    public void validFormat02() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "01113927054", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 03")
    public void validFormat03() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "0--1...1.1.3.9.27-0-5-4", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 04")
    public void validFormat04() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "280.550.810-69", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 05")
    public void validFormat05() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "267.771.550-31", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 06")
    public void validFormat06() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "822.506.430-59", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 07")
    public void validFormat07() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "788.557.760-02", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 08")
    public void validFormat08() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "218.897.860-98", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 09")
    public void validFormat09() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "170.340.740-70", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for valid CPF format 10")
    public void validFormat10() {
        Assertions.assertDoesNotThrow(
                () -> new User("Juca", "email@mail.com", "723.262.170-12", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for invalid CPF values 01")
    public void invalidValue01() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "704.966.990-44", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for invalid CPF values 02")
    public void invalidValue02() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "679.454.890-12", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for invalid CPF values 03")
    public void invalidValue03() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "201.175.980-48", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for invalid CPF values 04")
    public void invalidValue04() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "183.774.400-52", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

    @Test
    @DisplayName("Test for invalid CPF values 05")
    public void invalidValue05() {
        Assertions.assertThrows(UserException.class,
                () -> new User("Juca", "email@mail.com", "236.289.720-50", "912345678", LocalDateTime.now().minusYears(14), address, UserType.CLIENT, "123456ab", true, order));

    }

}
