package com.example.test2.service.impl;

import com.example.test2.model.Product;
import com.example.test2.repository.ProductRepo;
import com.example.test2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public Iterable<Product> listAll() {
        return productRepo.findAll();
    }
}
