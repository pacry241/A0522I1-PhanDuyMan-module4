package com.example.demotest.service.impl;

import com.example.demotest.model.ProductType;
import com.example.demotest.repository.IProductTypeRepository;
import com.example.demotest.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;
    @Override
    public Iterable<ProductType> listAll() {
        return productTypeRepository.findAll();
    }
}
