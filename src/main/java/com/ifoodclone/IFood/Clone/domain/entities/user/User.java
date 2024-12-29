package com.ifoodclone.IFood.Clone.domain.entities.user;

import com.ifoodclone.IFood.Clone.oldversion.domain.address.Address;
import com.ifoodclone.IFood.Clone.oldversion.domain.order.Order;
import com.ifoodclone.IFood.Clone.oldversion.domain.user.UserType;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.UserException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

//Clean Arc. User entity
public class User {

    private String name;
    private String email;
    private String CPF;
    private String phoneNumber;
    private LocalDateTime birthday;
    private Address address;
    private UserType usertype;
    private String password;
    private Boolean active;
    private List<Order> orders = new ArrayList<>();

    public User(String name, String email, String CPF, String phoneNumber, LocalDateTime birthday, Address address, UserType usertype, String password, Boolean active, List<Order> orders) throws UserException {

        if (!isCPFValid(CPF)) {
            throw new UserException("Invalid CPF");
        }

        if (!isAgeValid(birthday)) {
            throw new UserException("Invalid Date");
        }

        this.name = name;
        this.email = email;
        this.CPF = CPF;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.address = address;
        this.usertype = usertype;
        this.password = password;
        this.active = active;
        this.orders = orders;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isCPFValid(String cpf) {
        if(cpf == null) {
            return false;
        }

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 || !cpf.matches("\\d+")) {
            return false;
        }

        int sum = 0;
        for(int i = 0; i < 9; i++) {
            sum = sum + (cpf.charAt(i) - '0') * (10 - i);
        }

        int module = 11 - (sum % 11);
        int firstDigit = (module == 10 || module == 11) ? 0 : module;

        sum = 0;
        for(int i = 0; i < 10; i++) {
            sum = sum + (cpf.charAt(i) - '0') * (11 - i);
        }

        module = 11 - (sum % 11);
        int secondDigit = (module == 10 || module == 11) ? 0 : module;

        if (cpf.charAt(9) - '0' != firstDigit || cpf.charAt(10) - '0' != secondDigit) {
            return false;
        }

        return true;
    }

    public boolean isAgeValid(LocalDateTime birthday) {
        LocalDate dateNow = LocalDateTime.now().toLocalDate();
        return Period.between(birthday.toLocalDate(), dateNow).getYears() >= 12;
    }
}
