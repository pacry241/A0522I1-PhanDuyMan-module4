package com.example.md4_case_study.service.employee.Impl;

import com.example.md4_case_study.model.employee.Position;
import com.example.md4_case_study.repository.employee.PositionRepository;
import com.example.md4_case_study.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PositionServiceImpl implements PositionService<Position> {
    @Autowired
    private PositionRepository repository;

    @Override
    public List<Position> findAll() {
        return this.repository.findAll();
    }
}
