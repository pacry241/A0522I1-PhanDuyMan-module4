package com.example.product_springdatarepository.repository;

import com.example.product_springdatarepository.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product",nativeQuery = true)
    Page<Product> findAll (Pageable pageable);

    @Query(value = "select * from product s where s.name like %:keyword% or s.description like %:keyword%",nativeQuery = true)
    List<Product> findByNameContainingOrDescriptionContaining (String nameProduct);

    Product findByNameContaining ( String nameProduct);
}
