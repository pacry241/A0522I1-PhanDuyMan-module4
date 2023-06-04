package com.example.md4_case_study.repository.employee;

import com.example.md4_case_study.model.customer.Customer;
import com.example.md4_case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findEmployeeByEmployeeNameContainingAndEmployeePhone(String name, String phone, PageRequest of);

    Page<Employee> findEmployeeByEmployeeNameContainingIgnoreCaseAndEmployeeEmailIgnoreCase(String name, String email, PageRequest of);

    Optional<Employee> findFirstByEmail(String email);

    Optional<Employee> findFirstByPhone(String phone);

    Optional<Employee> findFirstByIdCard(String idCard);

    Page<Employee> findEmployeeByEmployeeNameContainingIgnoreCaseAndEmployeeEmailAndDivisionId(
            String name, String email, String division, PageRequest of);
    Page<Employee> findAllByEmployeeNameContainingIgnoreCaseAndEmployeeEmailContainingAndPositionId(
            String name, String email, String position, PageRequest of);
    Page<Employee> findAllByEmployeeNameContainingIgnoreCaseAndEmployeeEmailContainingAndEducationDegreeId(
            String name, String email, String educationDegree, PageRequest of);

    @Query(value = "select e from employee as e", countQuery = "select e from employee as e")
    Page<Employee> findAllWithPage(PageRequest of);

    @Query(value = "select e from employee as e where upper(employee_name) like upper(:searchName) and upper(email) like upper(:searchEmail) and division_id like upper(:searchDivision) and education_degree_id like upper(:searchEducation) and position_id like upper(:searchPosition)",
            countQuery ="select e from employee as e where upper(employee_name) like upper(:name) and upper(email) like upper(:searchEmail) and division_id like upper(:searchDivision) and education_degree_id like upper(:searchEducation) and position_id like upper(:searchPosition)",
            nativeQuery = true)
    Page<Employee> findAllAndSearch(@Param("searchName") String searchName, @Param("searchEmail") String searchEmail,
                                    @Param("searchDivision") String searchDivision, @Param("searchEducation") String searchEducation,
                                    @Param("searchPosition") String searchPosition, PageRequest of);
}
