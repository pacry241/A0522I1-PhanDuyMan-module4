package com.example.exem_final.validate;

import com.example.exem_final.model.Bill;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class ProductValid implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Bill bill = (Bill) target;
        LocalDate value = bill.getPublishDate();
        if (value == null){
            errors.rejectValue("publishDate","","không để trống");
        }
        LocalDate now = LocalDate.now();
        if (value.compareTo(now) > 0){
            errors.rejectValue("publishDate","","Không nhập ngày hôm nay");
        };
    }
}
