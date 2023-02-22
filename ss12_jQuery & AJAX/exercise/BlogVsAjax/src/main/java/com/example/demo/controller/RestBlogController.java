package com.example.demo.controller;

import com.example.demo.model.BlogUp;
import com.example.demo.model.Category;
import com.example.demo.service.impl.BlogUpService;
import com.example.demo.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api-blog")
public class RestBlogController {
    @Autowired
    private BlogUpService blogUpService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<BlogUp> getList() {
        return blogUpService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogUp> findById(@PathVariable Integer id) {
        Optional<BlogUp> blogUpOptional = blogUpService.findBlogUpById(id);
        if (!blogUpOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogUpOptional.get(), HttpStatus.OK);
    }

    @GetMapping("category")
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<List<BlogUp>> findBlogByCategory(@PathVariable Integer id) {
        Category category = categoryService.findById(id);
        List<BlogUp> blogList = blogUpService.findBlogsByCategory(category);
        if (blogList.isEmpty()) {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
