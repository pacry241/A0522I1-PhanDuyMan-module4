package com.example.product_springdatarepository.service.impl;

import com.example.product_springdatarepository.model.Product;
import com.example.product_springdatarepository.repository.IProductRepository;
import com.example.product_springdatarepository.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;


    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        if (name != null){/*for(Product p: iterable){
                productList.add(p);
            }*/
            //Iterable<Product> iterable = repository.findByNameContaining(name);
            List<Product> productList = new ArrayList<>();

            return productList;
        }
        return repository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        Iterable<Product> iterable = repository.findAll();
        List<Product> productList = new ArrayList<>();
        for(Product p: iterable){
            productList.add(p);
        }
        return productList;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
