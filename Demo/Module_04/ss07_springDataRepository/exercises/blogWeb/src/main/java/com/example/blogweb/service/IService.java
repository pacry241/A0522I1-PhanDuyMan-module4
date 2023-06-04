package com.example.blogweb.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    void save(T t);
    T findById(int id);
    void update(T t);
    void delete(T t);
}
