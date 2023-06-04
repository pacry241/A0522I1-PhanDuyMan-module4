package com.example.md4_case_study.service.customer.Impl;

import com.example.md4_case_study.model.customer.CustomerType;
import com.example.md4_case_study.repository.customer.CustomerTypeRepository;
import com.example.md4_case_study.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService<CustomerType> {
    @Autowired
    private CustomerTypeRepository repository;

    @Override
    public List<CustomerType> findAll() {
        return this.repository.findAll();
    }
}
