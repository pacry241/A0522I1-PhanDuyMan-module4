package com.example.productorm.repository;

import com.example.productorm.model.Product;

import java.util.List;

public interface CRUDRepository<T> {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(Product product);
    void delete(Product product);
}
