package com.example.test2.repository;

import com.example.test2.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepo extends PagingAndSortingRepository<ProductType, Integer> {
}
