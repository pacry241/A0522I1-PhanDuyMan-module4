package com.example.demoretest.service.customer;

import com.example.demoretest.model.Customer;
import com.example.demoretest.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> finAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> finById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }
}
