package com.example.demo.Service.impl;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.IProductService;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public Page<Product> getAll(PageRequest pageRequest) {
        return repository.findAllWithPage(pageRequest);
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
