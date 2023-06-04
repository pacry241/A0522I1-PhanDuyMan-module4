package com.example.md4_case_study.service.customer;

import com.example.md4_case_study.dto.customer.CustomerHaveBooking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface CustomerService<T> {
    void create(T t);

    void deleteById(Long id);

    T findById(Long id);

    List<T> findAll();

    Page<CustomerHaveBooking> findAllCustomerHaveBooking(PageRequest of);

//    void checkExists(CustomerDto customerDto, BindingResult bindingResult);

    Page<T> findAllWithPage(PageRequest of);

    Page<T> findAllByNameAndEmailAndType(String name, String email, Long customerType, PageRequest of);

    Page<T> findAllByNameAndEmail(String name, String email, PageRequest of);
}
