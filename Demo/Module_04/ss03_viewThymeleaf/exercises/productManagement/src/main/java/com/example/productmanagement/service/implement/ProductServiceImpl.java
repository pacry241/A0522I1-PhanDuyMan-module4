package com.example.productmanagement.service.implement;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.implement.ProductRepositoryImpl;
import com.example.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepositoryImpl productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void create(Product product) throws Exception {
        productRepository.create(product);
    }

    @Override
    public void update(Product product) throws Exception {
        productRepository.update(product);
    }

    @Override
    public void delete(int id) throws Exception {
        productRepository.delete(id);
    }

    @Override
    public Product findById(int id) throws Exception {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) throws Exception {
        return productRepository.findByName(name);
    }
}
