package com.example.imageday.validator;

import com.example.imageday.model.Comment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class feedbackValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Comment.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Comment comment =(Comment) target;
        String feedback = comment.getFeedback();
        if (feedback.equals("Fuck")){
            errors.rejectValue("feedback","feedback.error");
        }
    }
}
