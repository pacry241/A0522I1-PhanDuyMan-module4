package com.example.exem_final.service.impl;

import com.example.exem_final.model.ProductType;
import com.example.exem_final.repository.ProductTypeRepository;
import com.example.exem_final.service.ProductTypeService;
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
