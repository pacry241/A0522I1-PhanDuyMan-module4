package com.example.test.controller;

import com.example.test.model.ServiceFree;
import com.example.test.service.impl.FreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("free")
public class FreeController {
    @Autowired
    private FreeService freeService;

    @GetMapping("")
    public String showAll(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model){
            model.addAttribute("listService",this.freeService.findAllWithPage(PageRequest.of(page,2)));
        return "home";
    }

    @GetMapping("/search")
    public String showAllWithCountDown(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "keyword",defaultValue = "")String keyword,
                                       @RequestParam(value = "keyword2",defaultValue = "0")Long keyword2,
                                       @RequestParam(value = "keyword3",defaultValue = "")String keyword3,
                                       Model model){

        if (keyword.equals("")&&keyword2==0&&keyword3.equals("")){
            model.addAttribute("listService",this.freeService.findAllWithPage(PageRequest.of(page,2)));
            return "home";
        }
        if (keyword.equals("")&&keyword3.equals("")){
            model.addAttribute("listService",this.freeService.findAllWithCountDown(keyword2,PageRequest.of(page,2)));
            return "home";
        }
        model.addAttribute("listService",this.freeService.findAllWithCountDown(keyword2,PageRequest.of(page,2)));
        return "home";
    }

    @GetMapping("edit/{id}")
    public String editServiceFree(@PathVariable("id") Long id, Model model){
        model.addAttribute("service",this.freeService.findById(id));
        return "edit";
    }

    @PostMapping("update")
    public String updateCustomer(@Valid @ModelAttribute("service") ServiceFree serviceFree, BindingResult bindingResult, Model model){
        new ServiceFree().validate(serviceFree, bindingResult);
        if (bindingResult.hasErrors()){
            return "edit";
        }
        this.freeService.save(serviceFree);
        return "redirect:/free";
    }

    @GetMapping("delete/{id}")
    public String deleteBill(@PathVariable("id") Long id) {
        freeService.deleteById(id);
        return "redirect:/free";
    }

    @GetMapping("create")
    public String showFormCreate(ServiceFree serviceFree, Model model) {
        model.addAttribute("service",serviceFree);
        return "create";

    }

    @PostMapping("add")
    public String addBill(@Validated @ModelAttribute("service") ServiceFree serviceFree, BindingResult bindingResult) {
        new ServiceFree().validate(serviceFree, bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        this.freeService.save(serviceFree);
        return "redirect:/free";
    }

}
