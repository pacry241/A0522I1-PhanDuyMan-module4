package com.example.customercs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

public interface ICustomerService<T> {
    void save(T t);

    void delete(T t);

    void deleteById(Long id);

    T findById(Long id);

    List<T> findAll();

    Page<T> findAllWithPage(PageRequest pageRequest);
}
