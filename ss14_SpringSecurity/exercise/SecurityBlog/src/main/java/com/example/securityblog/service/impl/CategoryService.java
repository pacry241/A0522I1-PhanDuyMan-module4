package com.example.securityblog.service.impl;

import com.example.securityblog.model.Category;
import com.example.securityblog.repository.CategoryRepository;
import com.example.securityblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllById(Integer id) {
        return (List<Category>) categoryRepository.findById(id).orElse(new Category());
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(new Category());
    }
}
