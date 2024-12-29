package com.ifoodclone.IFood.Clone.oldversion.validation.cnpj;

import com.ifoodclone.IFood.Clone.oldversion.infra.exception.RestaurantException;

public class CNPJValidator{

    public void isValid(String cnpj) throws RestaurantException {

        if (cnpj == null) {
            throw new RestaurantException("CNPJ can't be null");
        }

        cnpj = cnpj.replaceAll("[^\\d]", "");

        if (cnpj.length() != 14) {
            throw new RestaurantException("Invalid CNPJ size");
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
        if (firstDigit != cnpj.charAt(12) || secondDigit != cnpj.charAt(13)) {
            throw new RestaurantException("Invalid CNPJ digits");
        }
    }
}
