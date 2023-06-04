package com.example.casestudy.controller;

import com.example.casestudy.service.IServiceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private IServiceModelService serviceModelService;

    @GetMapping
    public String showServicePage(Model model){
        model.addAttribute("services", serviceModelService.findAll());
        return "home";
    }
}
