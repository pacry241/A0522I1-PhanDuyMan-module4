package com.example.demo.controller;

import com.example.demo.model.Music;
import com.example.demo.service.Impl.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("music")
public class MusicController {
    @Autowired
    private MusicService service;

    @GetMapping("")
    public String showCreatePage(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String createMusic(@Validated @ModelAttribute("music") Music music, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        service.save(music);
        model.addAttribute("music", new Music());
        model.addAttribute("message", "New Music " + music.getName() + " created successfully");
        return "create";
    }
}
