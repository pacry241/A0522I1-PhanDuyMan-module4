package com.codegym.service;

import com.codegym.dto.StudentListDto;
import com.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    List<StudentListDto> getAll();

    void save(Student student);

    Student findById(Integer codeStudent);
}
