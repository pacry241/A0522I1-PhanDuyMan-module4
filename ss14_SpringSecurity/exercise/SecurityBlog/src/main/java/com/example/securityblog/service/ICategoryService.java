package com.example.securityblog.service;

import com.example.securityblog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    List<Category> findAllById(Integer id);

    Category findById(Integer id);
}
