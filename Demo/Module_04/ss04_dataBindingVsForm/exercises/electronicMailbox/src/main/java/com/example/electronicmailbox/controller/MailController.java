package com.example.electronicmailbox.controller;

import com.example.electronicmailbox.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MailController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("Mail",new Mail());
        return "home";
    }

    @PostMapping("/save")
    public String login(@ModelAttribute("Mail") Mail formMail, Model model){
        model.addAttribute("Mail", formMail);
        return "result";
    }
}
