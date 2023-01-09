package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.impl.ProductRepository;
import com.codegym.service.IPRoductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService implements IPRoductService {
    @Autowired
     private ProductRepository repository;
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Product product) throws Exception {
        repository.create(product);
    }

    @Override
    public void update(Product product) throws Exception {
        repository.update(product);
    }

    @Override
    public void delete(int id) throws Exception {
        repository.delete(id);
    }

    @Override
    public Product findById(int id) throws Exception {
        return repository.findById(id);
    }
}
