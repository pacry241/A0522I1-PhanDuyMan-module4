package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface CRUDRepository<T> {
    List<T> findAll();

    void create(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(String id) throws Exception;

    Product findById(String id) throws Exception;

    List<Product> findByName(String nameSearch);
}
