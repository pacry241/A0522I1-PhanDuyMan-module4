package com.example.productmanagement.repository.implement;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static  List<Product> list;

    static {
        list = new ArrayList<>();
        list.add(new Product(1,"Lam",123.3,"dep","Honda"));
        list.add(new Product(2,"Hong",12.3,"dep","Honda"));
        list.add(new Product(3,"Do",1.3,"xau","NOn"));
        list.add(new Product(4,"Vang",10.3,"dep","Suzuki"));
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public void create(Product product) {
        list.add(product);
    }

    @Override
    public void update(Product product) throws Exception {
        int index = 0;
        for(Product productFound : list){
            if(productFound.getId() == product.getId()){
                break;
            }
            index++;
        }
        if(index > list.size()){
            throw new Exception("product not found");
        }
        list.set(index,product);
    }

    @Override
    public void delete(int id) throws Exception {
        int index = 0;
        for(Product productFound : list){
            if(productFound.getId() == id){
                break;
            }
            index++;
        }
        if(index > list.size()){
            throw new Exception("product not found");
        }
        list.remove(index);
    }

    @Override
    public Product findById(int id) throws Exception {
        int index = 0;
        for(Product productFound : list){
            if(productFound.getId() == id){
                break;
            }
            index++;
        }
        if(index > list.size()){
            throw new Exception("product not found");
        }
        return list.get(index);
    }

    @Override
    public List<Product> findByName(String nameSearch) {
        List<Product> products = new LinkedList<>();
        for(Product product: list) {
            if (product.getName().matches("(.*)"+nameSearch+"(.*)")) {
                products.add(product);
            }
        }
        return products;
    }
}
