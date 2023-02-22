package com.example.final_module_4.validate;

import com.example.final_module_4.model.Event;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class ValidateEvent implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event) target;
        if (event.getTgBatDau()==null && event.getTgKetThuc()==null){
            errors.rejectValue("tgBatDau", "tgBatDau", null, "Vui lòng chọn ngày bắt đầu");
            errors.rejectValue("tgKetThuc", "tgKetThuc", null, "Vui lòng chọn ngày kết thúc");
        } else if (event.getTgBatDau()==null ){
            errors.rejectValue("tgBatDau", "tgBatDau", null, "Vui lòng chọn ngày bắt đầu");
        }else if (event.getTgKetThuc()==null){
            errors.rejectValue("tgKetThuc", "tgKetThuc", null, "Vui lòng chọn ngày kết thúc");
        } else if (event.getTgBatDau().getDay() > event.getTgKetThuc().getDay()) {
            errors.rejectValue("tgKetThuc", "DateValidate", null, "Thời gia kết thúc phải lớn hơn thời gian bắt đầu ít nhất một ngày");
        }
    }
}
