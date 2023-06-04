package com.example.md4_case_study.service.employee.Impl;

import com.example.md4_case_study.model.employee.EducationDegree;
import com.example.md4_case_study.repository.employee.EducationDegreeRepository;
import com.example.md4_case_study.service.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EducationDegreeServiceImpl implements EducationDegreeService<EducationDegree> {
    @Autowired
    private EducationDegreeRepository repository;

    @Override
    public List<EducationDegree> findAll() {
        return this.repository.findAll();
    }
}
