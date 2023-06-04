package com.example.md4_case_study.service.employee.Impl;

import com.example.md4_case_study.model.employee.Employee;
import com.example.md4_case_study.repository.employee.EmployeeRepository;
import com.example.md4_case_study.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService<Employee> {
    @Autowired
    private EmployeeRepository repository;


    @Override
    public void create(Employee employee) {
        this.repository.save(employee);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        Employee employee = this.repository.findById(id).orElse(null);
        if (employee == null) {
//            throw new ObjectNotFound();
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Page<Employee> findAllWithPage(PageRequest of) {
        return this.repository.findAllWithPage(of);
    }

    @Override
    public Page<Employee> findAllAndSearch(String searchName, String searchEmail, String searchDivision, String searchEducation, String searchPosition, PageRequest of) {
        return this.repository.findAllAndSearch(searchName, searchEmail, searchDivision, searchEducation, searchPosition, of);
    }

    @Override
    public Page<Employee> findAllByNameAndEmailAndDivision(String name, String email, String division, PageRequest of) {
        return this.repository.findEmployeeByEmployeeNameContainingIgnoreCaseAndEmployeeEmailAndDivisionId(name, email, division, of);
    }

    @Override
    public Page<Employee> findAllByNameAndEmail(String name, String email, PageRequest of) {
        return this.repository.findEmployeeByEmployeeNameContainingIgnoreCaseAndEmployeeEmailIgnoreCase(name, email, of);
    }
}
