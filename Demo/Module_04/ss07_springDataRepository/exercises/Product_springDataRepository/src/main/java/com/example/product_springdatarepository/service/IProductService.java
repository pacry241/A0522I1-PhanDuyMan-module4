package com.example.product_springdatarepository.service;

import com.example.product_springdatarepository.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    void save (Product product);
    void delete (Integer id);
    List<Product> findByName(String name);
    Product findById (Integer id);
    List<Product> getAll();
    Page<Product> findAll (Pageable pageable);
}
