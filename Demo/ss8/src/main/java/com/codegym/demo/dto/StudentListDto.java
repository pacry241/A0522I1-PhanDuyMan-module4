package com.codegym.demo.dto;

import com.codegym.demo.model.Classroom;

public class StudentListDto {
    private Integer codeStudent;
    private String nameStudent;
    private Double point;
    private Integer gender;
    private Classroom classroom;

    public StudentListDto() {
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public StudentListDto(Integer codeStudent, String nameStudent, Double point, Integer gender) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
    }

    public StudentListDto(String nameStudent, double point, Integer gender) {
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
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

    public void setPoint(double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
