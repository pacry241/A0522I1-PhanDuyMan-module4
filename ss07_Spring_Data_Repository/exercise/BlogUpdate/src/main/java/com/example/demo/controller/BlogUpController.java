package com.example.demo.controller;

import com.example.demo.model.BlogUp;
import com.example.demo.service.impl.BlogUpService;
import com.example.demo.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("home")
public class BlogUpController {
    @Autowired
    private BlogUpService service;
    @Autowired
    private CategoryService categoryService;

//    @GetMapping("")
//    public ModelAndView findAll() {
//        List<BlogUp> blogList = service.findAll();
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("blogList", blogList);
//        return modelAndView;
//    }

    @GetMapping("")
    public ModelAndView getAllWithPage(@RequestParam(value = "page", defaultValue = "0")int page) {
        Sort sort = Sort.by("time");
        Page<BlogUp> blogList = service.getAllWithPage(PageRequest.of(page,2,sort));
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String pageCreate(@ModelAttribute BlogUp blog, Model model) {
        model.addAttribute("blog", blog);
        model.addAttribute("listCategory", categoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String addProduct(@ModelAttribute BlogUp blog, RedirectAttributes redirectAttributes) {
        service.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create Blog: " + blog.getAuthor() + " done!");
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String pageEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", service.findById(id));
        model.addAttribute("listCategory", categoryService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute BlogUp blog, RedirectAttributes redirectAttributes) {
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
