package com.codegym.demo.service;

import com.codegym.demo.dto.StudentListDto;
import com.codegym.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IStudentService {
    List<StudentListDto> getAll();

    void save(Student student);

    Student findById(Integer codeStudent);

    Page<Student> getAllWithPage(PageRequest of);
}
