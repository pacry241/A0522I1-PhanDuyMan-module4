package com.example.prepare_exam.validator;

import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.Date;

@Configurable
public class EXPDateValidImpl implements ConstraintValidator<EXPDateValid, LocalDate> {
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        LocalDate now = LocalDate.now();
        return value.compareTo(now) >= 0 ;
    }
}
