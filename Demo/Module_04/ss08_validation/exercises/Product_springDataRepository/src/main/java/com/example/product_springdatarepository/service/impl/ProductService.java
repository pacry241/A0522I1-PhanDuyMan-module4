package com.example.product_springdatarepository.service.impl;

import com.example.product_springdatarepository.model.Product;
import com.example.product_springdatarepository.repository.IProductRepository;
import com.example.product_springdatarepository.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;


    @Override
    public Page<Product> getAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public void create(Product product)  {
        repository.save(product);
    }

    @Override
    public void update(Product product)  {
        repository.save(product);
    }

    @Override
    public void delete(Product product)  {
        repository.delete(product);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).orElse(new Product());
    }
}
