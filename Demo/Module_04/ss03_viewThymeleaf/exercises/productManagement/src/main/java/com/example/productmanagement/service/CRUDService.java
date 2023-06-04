package com.example.productmanagement.service;
import com.example.productmanagement.model.Product;

import java.util.List;
public interface CRUDService<T> {
    List<T> findAll();
    void create(T t) throws Exception;
    void update(T t) throws Exception;
    void delete(int id) throws Exception;
    Product findById(int id) throws Exception;
    List<T> findByName(String name) throws Exception;
}
