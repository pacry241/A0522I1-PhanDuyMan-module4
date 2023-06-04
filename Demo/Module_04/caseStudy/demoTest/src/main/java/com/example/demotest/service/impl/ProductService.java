package com.example.demotest.service.impl;

import com.example.demotest.model.Product;
import com.example.demotest.repository.IProductRepository;
import com.example.demotest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable<Product> listAll() {
        return productRepository.findAll();
    }


}
