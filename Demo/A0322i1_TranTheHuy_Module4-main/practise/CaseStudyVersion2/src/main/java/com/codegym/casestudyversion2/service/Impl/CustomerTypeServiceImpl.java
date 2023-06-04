package com.codegym.casestudyversion2.service.Impl;

import com.codegym.casestudyversion2.model.CustomerType;
import com.codegym.casestudyversion2.repository.CustomerTypeRepository;
import com.codegym.casestudyversion2.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService<CustomerType> {

    @Autowired
    private CustomerTypeRepository repository;

    @Override
    public List<CustomerType> findAll() {
        return this.repository.findAll();
    }
}
