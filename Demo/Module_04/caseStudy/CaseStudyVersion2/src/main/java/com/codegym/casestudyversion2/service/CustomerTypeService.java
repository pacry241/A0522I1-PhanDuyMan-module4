package com.codegym.casestudyversion2.service;


import java.util.List;

public interface CustomerTypeService<T> {
    List<T> findAll();
}
