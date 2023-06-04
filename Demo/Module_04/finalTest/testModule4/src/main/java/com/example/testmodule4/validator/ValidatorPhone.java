package com.example.testmodule4.validator;

import com.example.testmodule4.model.KhachHang;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidatorPhone implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return KhachHang.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        KhachHang khachHang = (KhachHang) target;
        String soDienThoai = khachHang.getSoDienThoai();
        if (soDienThoai.length()!=10){
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }if (!soDienThoai.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!soDienThoai.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
    }
}
