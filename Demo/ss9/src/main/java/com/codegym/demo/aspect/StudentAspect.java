package com.codegym.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {

    @After("execution(* com.codegym.demo.controller.StudentController.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name);
    }
}
