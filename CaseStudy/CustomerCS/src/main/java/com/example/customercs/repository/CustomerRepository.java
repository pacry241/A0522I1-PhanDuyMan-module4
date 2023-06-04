package com.example.customercs.repository;

import com.example.customercs.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "select * from customers",countQuery = "select * from customers",  nativeQuery = true)
    Page<Customer> findAllWithPage(PageRequest pageRequest);
}
