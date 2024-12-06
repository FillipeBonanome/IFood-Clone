package com.ifoodclone.IFood.Clone.validation.age;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<ValidAge, LocalDateTime> {

    @Override
    public void initialize(ValidAge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDateTime localDateTime, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate dateNow = LocalDateTime.now().toLocalDate();
        return Period.between(localDateTime.toLocalDate(), dateNow).getYears() >= 12;
    }
}
