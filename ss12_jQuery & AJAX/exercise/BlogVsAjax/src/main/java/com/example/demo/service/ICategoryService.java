package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    List<Category> findAllById(Integer id);

    Category findById(Integer id);
}
