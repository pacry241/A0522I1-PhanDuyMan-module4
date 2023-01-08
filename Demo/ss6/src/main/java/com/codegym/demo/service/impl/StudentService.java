package com.codegym.demo.service.impl;

import com.codegym.demo.dto.StudentListDto;
import com.codegym.demo.model.Student;
import com.codegym.demo.repository.IStudentRepository;
import com.codegym.demo.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<StudentListDto> getAll() {
        List<Student> students = iStudentRepository.findAll();
        List<StudentListDto> studentListDtos = new ArrayList<>();
        StudentListDto studentListDto;
        for (Student student: students) {
            studentListDto = new StudentListDto();
            BeanUtils.copyProperties(student, studentListDto);
            studentListDtos.add(studentListDto);
        }
        return studentListDtos;
    }

    @Override
    public void save(Student student) {
        if(student.getPoint()>0 && student.getPoint()<10) {

        }
        this.iStudentRepository.save(student);
    }

    @Override
    public Student findById(Integer codeStudent) {
        return iStudentRepository.findById(codeStudent).orElse(null);
    }
}
