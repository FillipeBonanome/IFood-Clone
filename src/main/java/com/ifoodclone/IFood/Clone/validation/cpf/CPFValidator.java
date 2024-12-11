package com.ifoodclone.IFood.Clone.validation.cpf;

import com.ifoodclone.IFood.Clone.infra.exception.UserException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFValidator {

    public void isValid(String cpf) throws UserException {

        if(cpf == null) {
            throw new UserException("CPF can't be null");
        }

        cpf = cpf.replaceAll("[^\\d]", "");

        if (cpf.length() != 11 || !cpf.matches("\\d+")) {
            throw new UserException("Invalid CPF format");
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
            throw new UserException("Invalid CPF digits");
        }
    }
}
