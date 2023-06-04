package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> getAllCategory(){
        return repository.findAll();
    } //findAll

    public void updateCategory(Category category){repository.save(category); } //add or update (tuy vao pri-key)

    public void removeCategoryById(Long id){
        repository.deleteById(id);
    }//delete truyen vao pri-key

    public Optional<Category> getCategoryById(Long id){
        return repository.findById(id);
    } //search theo id

}
