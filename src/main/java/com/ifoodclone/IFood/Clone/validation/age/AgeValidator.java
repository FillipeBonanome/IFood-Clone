package com.ifoodclone.IFood.Clone.validation.age;

import com.ifoodclone.IFood.Clone.infra.exception.UserException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class AgeValidator{
    public void isValid(LocalDateTime localDateTime) throws UserException {
        LocalDate dateNow = LocalDateTime.now().toLocalDate();
        if (Period.between(localDateTime.toLocalDate(), dateNow).getYears() < 12) {
            throw new UserException("You need to be at least 12 years old to create an account");
        }
    }
}
