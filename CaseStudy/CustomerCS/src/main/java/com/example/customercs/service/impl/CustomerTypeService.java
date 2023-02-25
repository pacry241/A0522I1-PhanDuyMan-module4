package com.example.customercs.service.impl;

import com.example.customercs.model.CustomerType;
import com.example.customercs.repository.CustomerTypeRepository;
import com.example.customercs.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private CustomerTypeRepository typeRepository;
    @Override
    public List findAll() {
        return this.typeRepository.findAll();
    }
}
