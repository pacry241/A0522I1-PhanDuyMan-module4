package com.example.demoretest.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> finAll();
    void save(T t);
    Optional<T> finById(Integer id);
    void remove(Integer id);
}
