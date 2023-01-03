package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IPRoductService {
    List<Product> findAll();

    void create(Product product) throws Exception;

    void update(Product product) throws Exception;

    void delete(int id) throws Exception;

    Product findById(int id) throws Exception;

    List<Product> findByName(String nameSearch);
}
