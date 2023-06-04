package com.codegym.casestudyversion2.validator;
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
    String message() default "Please select a right date!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
