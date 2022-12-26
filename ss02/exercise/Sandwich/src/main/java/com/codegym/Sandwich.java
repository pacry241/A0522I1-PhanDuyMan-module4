package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("menu")
public class Sandwich {
    @GetMapping("")
    public String showForm() {
        return "formMenu";
    }

    @PostMapping("")
    public String checkMenu(@RequestParam(value = "condiments", defaultValue = "") String condiments,
                            Model model) {
        if (condiments.equals("")) {
            model.addAttribute("result", "Không có gia vị nào cả");
        } else {
            model.addAttribute("result", condiments);
        }
        return "formMenu";
    }
}
