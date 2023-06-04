package com.example.demo.service;


import com.example.demo.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> getAllCategory();

    public void updateCategory(Category category);

    public void removeCategoryById(Long id);

    public Optional<Category> getCategoryById(Long id);

}
