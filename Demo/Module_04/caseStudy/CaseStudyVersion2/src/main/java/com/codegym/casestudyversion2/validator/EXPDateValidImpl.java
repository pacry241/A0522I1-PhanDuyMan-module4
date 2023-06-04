package com.codegym.casestudyversion2.validator;

import org.springframework.beans.factory.annotation.Configurable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.Date;

@Configurable
public class EXPDateValidImpl implements ConstraintValidator<EXPDateValid, Date> {
    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if(value == null) {
            return false;
        }
        Date now = new Date();
        return value.compareTo(now) > 0 | value.compareTo(now) < 0;
    }
}
