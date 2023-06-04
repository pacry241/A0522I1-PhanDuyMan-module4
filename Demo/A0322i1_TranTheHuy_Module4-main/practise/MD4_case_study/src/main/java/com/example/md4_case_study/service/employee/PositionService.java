package com.example.md4_case_study.service.employee;

import java.util.List;

public interface PositionService<T> {
    List<T> findAll();
}
