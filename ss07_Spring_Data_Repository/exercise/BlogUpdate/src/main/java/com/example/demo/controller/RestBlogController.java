package com.example.demo.controller;

import com.example.demo.model.BlogUp;
import com.example.demo.service.impl.BlogUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class RestBlogController {
    @Autowired
    BlogUpService blogUpService;

    @GetMapping("")
    public List<BlogUp> getList(){
        return blogUpService.findAll();
    }
}
