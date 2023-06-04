package com.example.newajaxblog.service;

import com.example.newajaxblog.model.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Long id);

    Blog save(Blog smartPhone);

    void remove(Long id);
}
