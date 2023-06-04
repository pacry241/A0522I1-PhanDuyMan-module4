package com.shoppingcart2.service.impl;


import com.shoppingcart2.model.Product;
import com.shoppingcart2.repository.IProductRepository;
import com.shoppingcart2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.iProductRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.iProductRepository.findById(id);
    }
}
