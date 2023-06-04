package com.example.demotestmorning.service;

import com.example.demotestmorning.model.Customer;

public interface ICustomerService {
    Iterable<Customer> listAll();
}
