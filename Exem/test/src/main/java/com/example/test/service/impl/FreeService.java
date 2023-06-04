package com.example.test.service.impl;

import com.example.test.model.ServiceFree;
import com.example.test.repository.FreeRepository;
import com.example.test.service.IServiceFree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FreeService implements IServiceFree<ServiceFree> {
    @Autowired
    private FreeRepository freeRepository;
    @Override
    public void save(ServiceFree serviceFree) {
        this.freeRepository.save(serviceFree);
    }

    @Override
    public void delete(ServiceFree serviceFree) {
        this.freeRepository.delete(serviceFree);
    }

    @Override
    public void deleteById(Long id) {
        this.freeRepository.deleteById(id);
    }

    @Override
    public ServiceFree findById(Long id) {
        return this.freeRepository.findById(id).orElse(new ServiceFree());
    }

    @Override
    public Page findAllWithPage(PageRequest pageRequest) {
        return this.freeRepository.findAllWithPage(pageRequest);
    }

    @Override
    public Page<ServiceFree> findAllWithCountDown(Long keyword, PageRequest pageRequest) {
        return this.freeRepository.findAllByCountDown(keyword,pageRequest);
    }

    @Override
    public Page<ServiceFree> findByNameServiceContainingAndCountDownContainingAndDescriptionFreeContaining(String name, Long count, String note, PageRequest pageRequest) {
        return this.findByNameServiceContainingAndCountDownContainingAndDescriptionFreeContaining(name,count,note,pageRequest);
    }

    @Override
    public Page<ServiceFree> findByNameServiceOrAndDescriptionFree(String keyword, String keyword2, PageRequest pageRequest) {
        return this.freeRepository.findByNameServiceOrAndDescriptionFree(keyword, keyword2, pageRequest);
    }
}
