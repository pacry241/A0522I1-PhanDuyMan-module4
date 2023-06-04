package com.codegym.casestudyversion2.service.Impl;

import com.codegym.casestudyversion2.dto.CustomerDto;
import com.codegym.casestudyversion2.model.Customer;
import com.codegym.casestudyversion2.repository.CustomerRepository;
import com.codegym.casestudyversion2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService<Customer> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void save(Customer customer) {
        this.repository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.repository.delete(customer);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = this.repository.findById(id).orElse(null);
        if (customer == null) {
            // nem dai cai loi ni
            throw new RuntimeException();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void checkExists(CustomerDto customerDto, BindingResult bindingResult) {
        // Identity card
        Customer existIdCard = this.repository.findFirstByCustomerIdCard(customerDto.getCustomerIdCard());
        // Email
        Customer existEmail = this.repository.findFirstByCustomerEmail(customerDto.getCustomerEmail());
        // Phone number
        Customer existPhone = this.repository.findFirstByCustomerPhone(customerDto.getCustomerPhone());

        if (customerDto.getCustomerId() == null) {
            //Add new
            if (!"".equals(customerDto.getCustomerEmail())) {
                if (existEmail != null) {
                    bindingResult.rejectValue("email", "Email was already exist!");
                }
            }
            if (!"".equals(customerDto.getCustomerPhone())) {
                if (existPhone != null) {
                    bindingResult.rejectValue("phone", "Phone was already exist!");
                }
            }
            if (!"".equals(customerDto.getCustomerIdCard())) {
                if (existIdCard != null) {
                    bindingResult.rejectValue("idCard", "Identity Card was already exist!");
                }
            }
        } else {
            //update
            if (existEmail != null) {
                if (!existEmail.getCustomerId().equals(customerDto.getCustomerId())) {
                    bindingResult.rejectValue("email", "Email was already exist!");
                }
            }
            if (existPhone != null) {
                if (!existPhone.getCustomerId().equals(customerDto.getCustomerId())) {
                    bindingResult.rejectValue("phone", "Phone was already exist!");
                }
            }
            if (existIdCard != null) {
                if (!existIdCard.getCustomerId().equals(customerDto.getCustomerId())) {
                    bindingResult.rejectValue("idCard", "Identity Card was already exist!");
                }
            }
        }
    }

    @Override
    public Page<Customer> findAllWithPage(PageRequest of) {
        return this.repository.findAllWithPage(of);
    }

    @Override
    public Page<Customer> findAllWithRequirement(String name, String phone, String email, PageRequest of) {
        return this.repository.findAllWithRequirement(name, phone, email, of);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContainingOrAndCustomerPhoneContainingOrAndCustomerEmailContaining(String name, String phone, String email, PageRequest of) {
        return this.repository.findAllByCustomerNameContainingOrAndCustomerPhoneContainingOrAndCustomerEmailContaining(name, phone, email, of);
    }

}
