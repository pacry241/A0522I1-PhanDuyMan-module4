package com.shoppingcart2.repository;


import com.shoppingcart2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
