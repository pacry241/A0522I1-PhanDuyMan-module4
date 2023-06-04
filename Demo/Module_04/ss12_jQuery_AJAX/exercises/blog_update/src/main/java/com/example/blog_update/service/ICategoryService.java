package com.example.blog_update.service;

import com.example.blog_update.model.Category;

public interface ICategoryService {
    Iterable<Category> findAll();

    Category findById(int id);
}
