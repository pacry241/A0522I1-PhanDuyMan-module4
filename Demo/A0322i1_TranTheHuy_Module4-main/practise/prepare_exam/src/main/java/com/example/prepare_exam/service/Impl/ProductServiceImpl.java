package com.example.prepare_exam.service.Impl;

import com.example.prepare_exam.model.Product;
import com.example.prepare_exam.repository.ProductRepository;
import com.example.prepare_exam.service.ProductService;
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
