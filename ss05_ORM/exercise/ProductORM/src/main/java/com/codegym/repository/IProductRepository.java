package com.codegym.repository;

import com.codegym.model.Product;

import javax.transaction.Transactional;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void create(Product product) throws Exception;

    void update(Product product) throws Exception;

    void delete(int id) throws Exception;

    Product findById(int id) throws Exception;

}
