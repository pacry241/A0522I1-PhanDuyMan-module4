package com.example.md4_case_study.service.customer.Impl;

import com.example.md4_case_study.dto.customer.CustomerHaveBooking;
import com.example.md4_case_study.model.customer.Customer;
import com.example.md4_case_study.repository.customer.CustomerRepository;
import com.example.md4_case_study.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

public class CustomerServiceImpl implements CustomerService<Customer> {
    @Autowired
    private CustomerRepository repository;


    @Override
    public void create(Customer customer) {
        this.repository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = this.repository.findById(id).orElse(null);
        if (customer == null){
//            throw new ObjectNotFound();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Page<CustomerHaveBooking> findAllCustomerHaveBooking(PageRequest of) {
        return this.repository.findAllCustomerHaveBooking((Pageable) of);
    }

    @Override
    public Page<Customer> findAllWithPage(PageRequest of) {
        return this.findAllWithPage(of);
    }

    @Override
    public Page<Customer> findAllByNameAndEmailAndType(String name, String email, Long customerType, PageRequest of) {
        return this.repository.findAllCustomerByNameAndEmailAndTypeId(name, email, customerType, of);
    }

    @Override
    public Page<Customer> findAllByNameAndEmail(String name, String email, PageRequest of) {
        return this.repository.findAllCustomerByNameAndEmail(name, email, of);
    }
}
