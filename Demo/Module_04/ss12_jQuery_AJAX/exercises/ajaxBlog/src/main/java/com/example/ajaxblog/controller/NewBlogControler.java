package com.example.ajaxblog.controller;

import com.example.ajaxblog.model.Blog;
import com.example.ajaxblog.repository.ICategoryRepository;
import com.example.ajaxblog.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class NewBlogControler {
    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    ICategoryRepository categoryRepository;

    @GetMapping("/list")
    public ModelAndView showListBlog(){
        List<Blog> blogs = blogService.getList();
        return new ModelAndView("list", "blogs", blogs);
    }
    @PostMapping
    public ResponseEntity<Blog> createSmartphone(@RequestBody Blog blog) {
        return new ResponseEntity<>(blog.(blog), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
