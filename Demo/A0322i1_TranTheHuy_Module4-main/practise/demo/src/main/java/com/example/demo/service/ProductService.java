package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();

    List<Product> getAllProduct(String name);

    List<Product> getAllProduct(Double price);

    Page<Product> getAllWithPage(PageRequest pageRequest);

    void updateProduct(Product product);

    void removeProductById(Long id);

    Optional<Product> getProductById(Long id);

    List<Product> getAllProductByCategoryId(Long id);
}
