package com.example.demo.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public String showErrorPage(){
        return "errorBook";
    }
}
