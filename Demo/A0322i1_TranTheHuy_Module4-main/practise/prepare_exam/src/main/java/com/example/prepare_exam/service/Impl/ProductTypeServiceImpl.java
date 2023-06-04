package com.example.prepare_exam.service.Impl;

import com.example.prepare_exam.model.ProductType;
import com.example.prepare_exam.repository.ProductTypeRepository;
import com.example.prepare_exam.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository repository;

    @Override
    public Iterable<ProductType> listAll() {
        return this.repository.findAll();
    }
}
