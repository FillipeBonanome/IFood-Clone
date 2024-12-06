package com.ifoodclone.IFood.Clone.validation.cpf;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<ValidCPF, String> {
    @Override
    public void initialize(ValidCPF constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
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
}
