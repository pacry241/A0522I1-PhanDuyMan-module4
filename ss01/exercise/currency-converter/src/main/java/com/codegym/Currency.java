package com.codegym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("currency")
public class Currency {
    @GetMapping("")
    public String showForm() {
        return "form";
    }
    @PostMapping("usd")
    public String currencyNow(@RequestParam("rate") int rate, @RequestParam("usd") int Usd, Model model){
        model.addAttribute("result",rate*Usd);
        return "result";
    }
}
