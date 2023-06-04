package com.example.ajaxblog.service;

import com.example.ajaxblog.model.Category;
import com.example.ajaxblog.repository.ICategoryRepository;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
