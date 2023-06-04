package com.example.product_springdatarepository.service;

import com.example.product_springdatarepository.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Page<Product> getAll(PageRequest pageRequest);

    void create(Product product) ;

    void update(Product product) ;

    void delete(Product product) ;

    Product findById(int id) ;
}
