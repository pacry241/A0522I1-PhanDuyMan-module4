package com.example.demotestmorning.repository;

import com.example.demotestmorning.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Integer> {

}
