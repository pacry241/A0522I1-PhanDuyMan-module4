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
    public String checkMenu(@RequestParam(value = "Lettuce", defaultValue = "") String Lettuce,
                            @RequestParam(value = "Tomato", defaultValue = "") String Tomato,
                            @RequestParam(value = "Mustard", defaultValue = "") String Mustard,
                            @RequestParam(value = "Sprouts", defaultValue = "") String Sprouts,
                            Model model) {
        if (Tomato.equals("") && Lettuce.equals("") && Mustard.equals("") && Sprouts.equals("")) {
            model.addAttribute("result", "Không có gia vị nào cả");
        } else {
            model.addAttribute("result", Tomato + " " + Lettuce + " " + Mustard + " " + Sprouts);
        }
        return "formMenu";
    }
}
