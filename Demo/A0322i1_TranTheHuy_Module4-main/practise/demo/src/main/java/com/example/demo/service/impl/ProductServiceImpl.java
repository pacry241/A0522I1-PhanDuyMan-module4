package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProduct() {
        return repository.findAll();
    } //findAll

    @Override
    public List<Product> getAllProduct(String name) { //findAllByName
        return repository.findAllByRequirement(name);
    }

    @Override
    public List<Product> getAllProduct(Double price) {
        return repository.findAllByRequirement(price);
    }

    @Override
    public Page<Product> getAllWithPage(PageRequest pageRequest) {
        return repository.getAllWithPage(pageRequest);
    }

    public void updateProduct(Product product) {
        repository.save(product);
    } //add or update (tuy vao pri-key)

    public void removeProductById(Long id) {
        repository.deleteById(id);
    }//delete dua vao pri-key

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    } //search theo id

    public List<Product> getAllProductByCategoryId(Long id) {
        return repository.findAllByCategory_Id(id);
    }
    //findList theo ProductDTO.categoryId

}
