package com.example.test2.service.impl;

import com.example.test2.model.ProductType;
import com.example.test2.repository.ProductTypeRepo;
import com.example.test2.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    ProductTypeRepo productTypeRepo;

    @Override
    public Iterable<ProductType> listAll() {
        return productTypeRepo.findAll();
    }
}
