package com.example.casestudy.service;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save (Employee employee);
    Page<Employee> find (String keyword, Pageable pageable);
    void delette (Integer id);
    void update (Employee employee);
}
