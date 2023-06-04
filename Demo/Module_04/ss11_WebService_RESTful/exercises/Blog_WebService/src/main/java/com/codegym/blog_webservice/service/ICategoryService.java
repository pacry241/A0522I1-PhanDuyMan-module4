package com.codegym.blog_webservice.service;

import com.codegym.blog_webservice.model.Blog;
import com.codegym.blog_webservice.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    void remove(Long id);

}
