package com.example.exem_final.service.impl;

import com.example.exem_final.model.Product;
import com.example.exem_final.repository.ProductRepository;
import com.example.exem_final.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public Iterable<Product> listAll() {
        return this.repository.findAll();
    }
}
