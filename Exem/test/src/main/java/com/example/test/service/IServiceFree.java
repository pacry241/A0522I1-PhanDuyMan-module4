package com.example.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IServiceFree<T> {
    void save(T t);

    void delete(T t);

    void deleteById(Long id);

    T findById(Long id);

    Page<T> findAllWithPage(PageRequest pageRequest);

    Page<T> findAllWithCountDown(Long keyword,PageRequest pageRequest);
    Page<T> findByNameServiceContainingAndCountDownContainingAndDescriptionFreeContaining(String name, Long count, String note, PageRequest pageRequest);
    Page<T> findByNameServiceOrAndDescriptionFree(String keyword,String keyword2, PageRequest pageRequest);
}
