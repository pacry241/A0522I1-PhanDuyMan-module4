package com.example.customercs.service;

import java.util.List;

public interface ICustomerService<T> {
    void save(T t);

    void delete(T t);

    void deleteById(Long id);

    T findById(Long id);

    List<T> findAll();
}
