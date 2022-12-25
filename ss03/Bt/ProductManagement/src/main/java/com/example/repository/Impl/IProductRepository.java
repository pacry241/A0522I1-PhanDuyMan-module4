package com.example.repository.Impl;

import com.example.model.Product;
import com.example.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class IProductRepository implements CRUDRepository<Product> {
    private  static Map<String,Product> productMap;

    static {
        productMap = new LinkedHashMap<>();
        productMap.put("Pr001",new Product("Pr001","product 1",500,"tot","WUBI"));
        productMap.put("Pr002",new Product("Pr002","product 2",1000,"dep lam","CHILL"));
        productMap.put("Pr003",new Product("Pr003","product 3",7000,"dep luon","LOL"));
        productMap.put("Pr004",new Product("Pr004","product 4",900,"qua dep","CN"));
        productMap.put("Pr005",new Product("Pr005","product 5",20000,"qua tot","VNES"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) throws Exception {
        if(productMap.containsKey(product.getId())){
            throw new Exception("Duplicate id");
        }else{
            productMap.put(product.getId(),product);
        }
    }

    @Override
    public void update(Product product) throws Exception {
        if(!productMap.containsKey(product.getId())){
            throw new Exception("Product not Found");
        }else{
            productMap.put(product.getId(),product);
        }
    }

    @Override
    public void delete(String id) throws Exception {
        if(productMap.containsKey(id)){
            productMap.remove(id);
        }else{
            throw new Exception("Product not Found");
        }
    }

    @Override
    public Product findById(String id) throws Exception {
        if(productMap.containsKey(id)){
            return productMap.get(id);
        }
        throw new Exception("Product not Found");
    }

    @Override
    public List<Product> findByName(String nameSearch) {
        List<Product> products = new LinkedList<>();
        for(Product product: new ArrayList<>(productMap.values())) {
            if (product.getName().matches("(.*)"+nameSearch+"(.*)")) {
                products.add(product);
            }
        }
        return products;
    }
}
