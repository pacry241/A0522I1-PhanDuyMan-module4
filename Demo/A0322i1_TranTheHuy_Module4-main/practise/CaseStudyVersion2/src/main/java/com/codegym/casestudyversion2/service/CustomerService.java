package com.codegym.casestudyversion2.service;

import com.codegym.casestudyversion2.dto.CustomerDto;
import com.codegym.casestudyversion2.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface CustomerService<T> {
    void save(T t);

    void delete(T t);

    void deleteById(Long id);

    T findById(Long id);

    List<T> findAll();

    void checkExists(CustomerDto customerDto, BindingResult bindingResult);

    Page<T> findAllWithPage(PageRequest of);

    Page<T> findAllWithRequirement(String name, String phone, String email, Pageable pageable);

    Page<T> findAllByCustomerNameContainingOrAndCustomerPhoneContainingOrAndCustomerEmailContaining(String name, String Phone, String email, PageRequest of);
}
