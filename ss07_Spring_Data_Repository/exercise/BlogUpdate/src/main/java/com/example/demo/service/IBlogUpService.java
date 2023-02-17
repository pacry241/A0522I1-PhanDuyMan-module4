package com.example.demo.service;

import com.example.demo.model.BlogUp;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IBlogUpService {
    List<BlogUp> findAll();
    void save(BlogUp blogUp);
    BlogUp findById(Integer id);

    Optional<BlogUp> findBlogUpById(Integer id);
    void update(BlogUp blogUp);
    void delete(BlogUp blogUp);
    List<BlogUp> findBlogsByCategory(Category category);


    Page<BlogUp> getAllWithPage(PageRequest pageRequest);
}
