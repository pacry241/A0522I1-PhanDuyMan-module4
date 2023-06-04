package com.example.demotest.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EXPDateValidImpl.class)
public @interface EXPDateValid {
    String message() default "Please select a date that before from current date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}