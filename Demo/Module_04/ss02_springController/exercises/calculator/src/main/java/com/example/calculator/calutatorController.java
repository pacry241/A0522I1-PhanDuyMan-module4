package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class calutatorController {

    @GetMapping()
    public String showForm(){
        return "index";
    }

    @PostMapping ()
    public String Spring(@RequestParam String operator, @RequestParam double number01, @RequestParam double number02, Model model){
        double result = 0;
        switch (operator){
            case "+":
                result = number01 + number02;
                break;
            case "-":
                result = number01 - number02;
                break;
            case "*":
                result = number01 * number02;
                break;
            case "/":
                result = number01 / number02;
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
