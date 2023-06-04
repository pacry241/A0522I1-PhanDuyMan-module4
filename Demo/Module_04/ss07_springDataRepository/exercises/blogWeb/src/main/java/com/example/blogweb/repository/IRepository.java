package com.example.blogweb.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    void save(T t);
    T findById(int id);
    void update(T t);
    void delete(T t);

    void SearchById(int id);
}
