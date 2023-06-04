package com.example.md4_case_study.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface EmployeeService<T> {

    void create(T t);

    void delete(Long id);

    T findById(Long id);

    List<T> findAll();

//    void checkExists(EmployeeDto employeeDto, BindingResult bindingResult);

    Page<T> findAllWithPage(PageRequest of);

    Page<T> findAllAndSearch(String searchName, String searchEmail, String searchDivision, String searchEducation, String searchPosition, PageRequest of);

    Page<T> findAllByNameAndEmailAndDivision(String name, String email, String division, PageRequest of);

    Page<T> findAllByNameAndEmail(String name, String email, PageRequest of);
}
