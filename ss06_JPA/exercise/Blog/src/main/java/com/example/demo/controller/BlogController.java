package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("home")
public class BlogController {
    @Autowired
    private BlogService service;

    @GetMapping("")
    public ModelAndView findAll() {
        List<Blog> blogList = service.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String pageCreate(@ModelAttribute Blog blog, Model model) {
        model.addAttribute("blog", blog);
        return "create";
    }

    @PostMapping("/save")
    public String addProduct(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        service.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create Blog: " + blog.getAuthor() + " done!");
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String pageEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", service.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        service.update(blog);
        redirectAttributes.addFlashAttribute("message", "Update Blog: " + blog.getAuthor() + " done!");
        return "redirect:/home";
    }

    //view
    @GetMapping("/view/{id}")
    public String pageView(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", service.findById(id));
        return "detail";
    }

    //delete
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model) {
        service.delete(service.findById(id));
        return "redirect:/home";
    }
}
