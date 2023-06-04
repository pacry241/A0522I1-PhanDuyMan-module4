package com.example.ajaxblog.service.impl;

import com.example.ajaxblog.model.Category;
import com.example.ajaxblog.repository.ICategoryRepository;
import com.example.ajaxblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryImpl implements ICategoryService {

    @Override
    public List<Category> findAll() {
        return null;
    }
}
