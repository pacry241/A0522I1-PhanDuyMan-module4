package com.codegym.demo.model;

import com.codegym.demo.utils.annotation.NameConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Student implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_student")
    private Integer codeStudent;
    @NameConstraint
    @Column(name = "name_student")
    @NotBlank(message = "Tên không được để trống")
    private String nameStudent;
    @Min(value = 0, message = "Điểm không được nhỏ hơn 0")
    @Max(value = 50, message = "Điểm không được quá 10")
    private Double point;
    private Integer gender;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classroom classroom;

    public Student() {
    }

    public Student(Integer codeStudent, String nameStudent, double point, Integer gender) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public double getPoint() {
        return point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if(!student.nameStudent.matches("^[A-Za-z ]{4,}$")) {
            errors.rejectValue("nameStudent", "", "Tên sai định dạng");
        }

    }
}
