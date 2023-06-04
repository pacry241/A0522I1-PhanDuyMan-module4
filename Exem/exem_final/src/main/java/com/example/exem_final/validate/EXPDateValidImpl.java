package com.example.exem_final.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class EXPDateValidImpl implements ConstraintValidator<EXPDateValid, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        LocalDate now = LocalDate.now();
        return value.compareTo(now) > 0 ;
    }
}
