package com.example.customercs.service.impl;

import com.example.customercs.model.Customer;
import com.example.customercs.repository.CustomerRepository;
import com.example.customercs.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService<Customer> {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.customerRepository.delete(customer);
    }

    @Override
    public void deleteById(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllWithPage(PageRequest pageRequest) {
        return customerRepository.findAllWithPage(pageRequest);
    }
}
