package com.example.demotest.repository;

import com.example.demotest.model.ProductType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends PagingAndSortingRepository<ProductType, Integer> {
}
