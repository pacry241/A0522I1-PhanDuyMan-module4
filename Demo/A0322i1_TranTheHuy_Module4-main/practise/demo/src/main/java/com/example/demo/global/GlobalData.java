package com.example.demo.global;

import com.example.demo.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalData {
    // tao bien toan cuc
    public static List<Product> cart;


    static {
        cart = new ArrayList<>();
    }


//    public void minusProduct(Product product) {
//        if (checkItemInCart(product)) {
//            List<Product> itemEntry = selectItemInCart(product);
//            if (itemEntry.size() < 2) {
//                removeProduct(product);
//            } else {
//                Integer newQuantity = itemEntry.size() - 1;
//                cart.(newQuantity);
//            }
//        }
//    }
//
//
//    private boolean checkItemInCart(Product product) {
//        for (Product entry: cart) {
//            if (entry.getId().equals(product.getId())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private List<Product> selectItemInCart(Product product) {
//        for (Product entry: cart) {
//            if (entry.getId().equals(product.getId())) {
//                return (List<Product>) entry;
//            }
//        }
//        return null;
//    }


//    public void addProduct(Product product) {
//        if (!checkItemInCart(product)) {
//            products.put(product, 1);
//        } else {
//            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
//            Integer newQuantity = itemEntry.getValue() + 1;
//            products.replace(itemEntry.getKey(), newQuantity);
//        }
//    }
//
//    public void removeProduct(Product product) {
//        if (checkItemInCart(product)) {
//            List<Product> itemEntry = selectItemInCart(product);
//            cart.remove(itemEntry);
//        }
//    }
//
//
//    public Integer countProductQuantity() {
//        Integer productQuantity = 0;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            productQuantity += entry.getValue();
//        }
//        return productQuantity;
//    }
//
//    public Integer countItemQuantity() {
//        return products.size();
//    }
//
//    public Float countTotalPayment() {
//        float payment = 0;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            payment += entry.getKey().getPrice() * (float) entry.getValue();
//        }
//        return payment;
//    }
}
