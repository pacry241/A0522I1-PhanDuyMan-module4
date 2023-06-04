package com.codegym.exam.repository;

import com.codegym.exam.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findByNameContainingOrEmailContainingOrClassName_NameContaining(Pageable pageable, String searchValName,
                                                                                  String searchValEmail, String searchValClassName);
}
