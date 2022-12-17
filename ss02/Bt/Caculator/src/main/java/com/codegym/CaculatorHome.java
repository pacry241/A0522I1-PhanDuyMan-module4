package com.codegym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("home")
public class CaculatorHome {

    @GetMapping("")
    public String showForm() {
        return "caculatorForm";
    }

    @PostMapping("")
    public String caculator(@RequestParam("first-operand") double firstNumber, @RequestParam("second-operand") double secondNumber,
                            @RequestParam("operator") String operator, Model model, RedirectAttributes redirectAttributes) {
        String result = "";

        switch (operator) {
            case "+":
                result = String.valueOf(firstNumber + secondNumber);
                break;
            case "-":
                result = String.valueOf(firstNumber - secondNumber);
                break;
            case "*":
                result = String.valueOf(firstNumber * secondNumber);
                break;
            case "/":
                result = secondNumber == 0 ? "Cannot division to zero" : String.valueOf(firstNumber / secondNumber);
                break;
        }

//        model.addAttribute("result", result); cách 1
//        cách 2:
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/home";
    }
}
