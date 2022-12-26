package com.example.controller;

import com.example.model.FormMail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class MailController {
    public static List<String> languageList = new ArrayList<>();
    public static List<Integer> pageList = new ArrayList<>();
    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(25);
        pageList.add(50);
        pageList.add(100);
    }




    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("languageList",languageList);
        model.addAttribute("pageList",pageList);

        model.addAttribute("formMail",new FormMail());
        return "home";
    }

    @PostMapping("/save")
    public String login(@ModelAttribute("formMail") FormMail formMail, Model model){
        model.addAttribute("formMail",formMail);
        return "result";
    }
}
