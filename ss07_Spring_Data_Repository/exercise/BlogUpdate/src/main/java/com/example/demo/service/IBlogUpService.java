package com.example.demo.service;

import com.example.demo.model.BlogUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IBlogUpService {
    List<BlogUp> findAll();
    void save(BlogUp blogUp);
    BlogUp findById(Integer id);
    void update(BlogUp blogUp);
    void delete(BlogUp blogUp);

    Page<BlogUp> getAllWithPage(PageRequest pageRequest);
}
