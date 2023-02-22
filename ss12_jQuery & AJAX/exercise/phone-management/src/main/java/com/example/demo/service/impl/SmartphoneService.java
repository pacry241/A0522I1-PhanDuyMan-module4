package com.example.demo.service.impl;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import com.example.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private SmartphoneRepository repository;
    @Override
    public Iterable<Smartphone> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return repository.save(smartphone);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
