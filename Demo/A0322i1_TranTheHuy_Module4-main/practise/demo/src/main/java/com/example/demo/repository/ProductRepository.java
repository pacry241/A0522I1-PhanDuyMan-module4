package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory_Id(Long id);

    @Query(value = "select p.id from product as p where name like :name", nativeQuery = true)
    List<Product> findAllByRequirement(@Param("name") String name);

    @Query(value = "select p.id from product as p where price like :price", nativeQuery = true)
    List<Product> findAllByRequirement(@Param("price") Double price);

    @Query(value = "select * from product", countQuery = "select * from product", nativeQuery = true)
    Page<Product> getAllWithPage(PageRequest pageRequest);


}
