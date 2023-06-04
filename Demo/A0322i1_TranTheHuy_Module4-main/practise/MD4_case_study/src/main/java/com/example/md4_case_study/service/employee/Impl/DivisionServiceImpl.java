package com.example.md4_case_study.service.employee.Impl;

import com.example.md4_case_study.model.employee.Division;
import com.example.md4_case_study.repository.employee.DivisionRepository;
import com.example.md4_case_study.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DivisionServiceImpl implements DivisionService<Division> {
    @Autowired
    private DivisionRepository repository;

    @Override
    public List<Division> findAll() {
        return this.repository.findAll();
    }
}
