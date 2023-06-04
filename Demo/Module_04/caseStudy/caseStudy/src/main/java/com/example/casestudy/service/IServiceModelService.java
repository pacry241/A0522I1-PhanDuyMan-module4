package com.example.casestudy.service;

import com.example.casestudy.model.service_model.ServiceClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceModelService {
    List<ServiceClass> findAll();
    void save (ServiceClass service);
    Page<ServiceClass> find (String keyword, Pageable pageable);
    void delette (Integer id);
    void update (ServiceClass service);
}
