package com.example.demotestmorning.validator;

import com.example.demotestmorning.model.Contract;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class ValidatorContract implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        Date publish = contract.getContractTime();
        if (publish == null){
            errors.rejectValue("contractTime", "contractTime.empty");
        }
    }
}
