package com.example.final_module_4.controller;

import com.example.final_module_4.model.Event;
import com.example.final_module_4.service.IEventService;
import com.example.final_module_4.validate.ValidateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EventController {
    @Autowired
    IEventService eventService;
    @Autowired
    ValidateEvent validateEvent;
    @GetMapping("/index")
    public String index( Model model){
        model.addAttribute("list", eventService.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("event", new Event());
        return "create";
    }
    @PostMapping("/create")
    public String createBlog(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult) {
        validateEvent.validate(event,bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        eventService.create(event);
        return "redirect:/index";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id")Long id, Model model){
        model.addAttribute("event", eventService.finById(id));
        return "view";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id")Long id, Model model){
        model.addAttribute("event", eventService.finById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String edit(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult) {
        validateEvent.validate(event,bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        eventService.create(event);
        return "redirect:/index";
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("idDelete") Long id) {
        eventService.delete(id);
        return "redirect:/index";
    }
    @GetMapping("/search")
    public String search(Model model,
//                         @RequestParam(value = "mucGiamGia") Double mucGiamGia,
                         @RequestParam(value = "tgBatDau",defaultValue = "") Date tgBatDau,
                         @RequestParam(value = "tgKetThuc",defaultValue = "")Date tgKetThuc
    ) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("list", eventService.findByTgBatDauContainingAndTgKetThucContaining(tgBatDau,tgKetThuc));
        return "index";
    }

}
