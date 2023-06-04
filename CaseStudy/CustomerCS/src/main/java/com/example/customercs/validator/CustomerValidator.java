package com.example.customercs.validator;

import com.example.customercs.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        Date datePublish = customer.getDateOfBirth();
        if (datePublish != null && datePublish.after(new Date())) {
            errors.rejectValue("dateOfBirth", "book.create.publishDate.afternow", "Ngày xuất bản không đúng");
        }
    }
}
