package com.example.md4_case_study.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CustomerTypeService<T> {
    List<T> findAll();
}
