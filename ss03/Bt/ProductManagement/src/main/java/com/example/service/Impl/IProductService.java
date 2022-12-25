package com.example.service.Impl;

import com.example.model.Product;
import com.example.repository.Impl.IProductRepository;
import com.example.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductService implements CRUDService<Product> {

    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void create(Product product) throws Exception {
        iProductRepository.create(product);
    }

    @Override
    public void update(Product product) throws Exception {
        iProductRepository.update(product);
    }

    @Override
    public void delete(String id) throws Exception {
        iProductRepository.delete(id);
    }

    @Override
    public Product findById(String id) throws Exception {
        return iProductRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String nameSearch) {
        return iProductRepository.findByName(nameSearch);
    }
}
