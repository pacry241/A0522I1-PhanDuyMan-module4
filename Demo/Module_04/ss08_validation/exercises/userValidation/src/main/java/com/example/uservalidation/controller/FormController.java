package com.example.uservalidation.controller;

import com.example.uservalidation.model.User;
import com.example.uservalidation.service.UserServiceImpl;
import com.example.uservalidation.validator.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/create")
    public String displayCreate(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

   /* @GetMapping("/list")
    public ModelAndView showListBlog(){
        List<User> users = userService.findAll();
        return new ModelAndView("index", "users", users);
    }*/

    @PostMapping("/create")
    public String checkValidation (@Valid @ModelAttribute("user")User user, BindingResult bindingResult){
        new PhoneNumberValidator().validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return "/index";
        }
        else {
           userService.save(user);
            return "/result";
        }
    }
      /*@PostMapping("/result")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        PhoneNumberValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }
        userService.save(user);
        return "result";
    }*/
}
