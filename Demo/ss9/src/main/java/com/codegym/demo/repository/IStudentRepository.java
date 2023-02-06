package com.codegym.demo.repository;

import com.codegym.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByNameStudentContainingAndGenderIs(String name, Integer gender);

    @Query(value = "select student.code_student from student where name like :name and gender = :gender;",nativeQuery = true)
    List<Student> findByNameAndGender(@Param("name") String name, @Param("gender") Integer gender);

    @Query(value = "select * from student", countQuery = "select * from student",nativeQuery = true)
    Page<Student> findAllWithPage(PageRequest pageRequest);
}
