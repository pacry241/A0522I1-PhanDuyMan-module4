package com.example.casestudy.service;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save (Customer customer);
    Page<Customer> find (String keyword, Pageable pageable);
    void delette (Integer id);
    void update (Customer customer);

}
