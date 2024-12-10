package com.ifoodclone.IFood.Clone.validation.cnpj;

import com.ifoodclone.IFood.Clone.validation.cnpj.ValidCNPJ;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CNPJValidator implements ConstraintValidator<ValidCNPJ, String> {
    @Override
    public void initialize(ValidCNPJ constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cnpj, ConstraintValidatorContext constraintValidatorContext) {

        if (cnpj == null) {
            return false;
        }

        cnpj = cnpj.replaceAll("[^\\d]", "");

        if (cnpj.length() != 14) {
            return false;
        }
        char firstDigit, secondDigit;
        int sum, number, weight, result;

        sum = 0;
        weight = 2;

        for(int i = 11; i >= 0; i--) {
            number = (int)(cnpj.charAt(i) - '0');
            sum = sum + (number * weight);
            weight = weight + 1;
            if (weight == 10) {
                weight = 2;
            }
        }

        result = sum % 11;
        if(result == 0 || result == 1) {
            firstDigit = '0';
        } else {
            firstDigit = (char)((11 - result) + '0');
        }

        sum = 0;
        weight = 2;
        for(int i = 12; i >= 0; i--) {
            number = (int)(cnpj.charAt(i) - '0');
            sum = sum + (number * weight);
            weight = weight + 1;
            if (weight == 10) {
                weight = 2;
            }
        }

        result = sum % 11;
        if (result == 0 || result == 1) {
            secondDigit = '0';
        } else {
            secondDigit = (char)((11 - result) + '0');
        }

        return ((firstDigit == cnpj.charAt(12)) && (secondDigit == cnpj.charAt(13)));
    }
}
