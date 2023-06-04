package com.example.casestudy.service;

import com.example.casestudy.model.service_model.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceModelService implements IServiceModelService{

    @Autowired
    private IServiceModelService serviceModelService;


    @Override
    public List<ServiceClass> findAll() {
        return serviceModelService.findAll();
    }

    @Override
    public void save(ServiceClass service) {
        serviceModelService.save(service);
    }

    @Override
    public Page<ServiceClass> find(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public void delette(Integer id) {
        serviceModelService.delette(id);
    }

    @Override
    public void update(ServiceClass service) {
        serviceModelService.update(service);
    }
}
