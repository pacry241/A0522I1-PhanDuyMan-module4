package com.codegym;

import org.springframework.stereotype.Service;

@Service
public class CaculatorService {
    public String resultCaculator(double firstNumber, double secondNumber, String operator){

        switch (operator) {
            case "+":
                return String.valueOf(firstNumber + secondNumber);

            case "-":
                return String.valueOf(firstNumber - secondNumber);

            case "*":
                return String.valueOf(firstNumber * secondNumber);

            case "/":
                return secondNumber == 0 ? "Cannot division to zero" : String.valueOf(firstNumber / secondNumber);
            default:
                return "Chưa thực hiện phép tính";
        }
    }
}
