package com.example.demotestmorning.service.impl;

import com.example.demotestmorning.model.Customer;
import com.example.demotestmorning.repository.CustomerRepo;
import com.example.demotestmorning.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public Iterable<Customer> listAll() {
            return customerRepo.findAll();
    }
}
