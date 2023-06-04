package com.codegym.blog_webservice.service;

import com.codegym.blog_webservice.model.Blog;
import com.codegym.blog_webservice.model.Category;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Long id);

    Blog save(Blog blog);

    void remove(Long id);

    List<Blog> findBlogsByCategory(Category category);
}
