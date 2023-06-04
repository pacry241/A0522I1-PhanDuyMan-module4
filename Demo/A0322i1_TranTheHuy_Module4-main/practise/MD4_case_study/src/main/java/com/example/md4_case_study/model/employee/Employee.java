package com.example.md4_case_study.model.employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(name = "employee_name", columnDefinition = "varchar(45)")
    private String employeeName;
    @Column(name = "date_of_birth", columnDefinition = "date")
    private LocalDate employeeBirthDay;
    @Column(name = "gender", columnDefinition = "bit")
    private Integer employeeGender;
    @Column(name = "identity_card", columnDefinition = "varchar(45)")
    private String employeeIdCard;
    @Column(name = "salary", columnDefinition = "double")
    private Double employee_salary;
    @Column(name = "phone_number", columnDefinition = "varchar(45)")
    private String employeePhone;
    @Column(name = "email", columnDefinition = "varchar(60)")
    private String employeeEmail;
    @Column(name = "address", columnDefinition = "varchar(120)")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "divisionId")
    private Division divisionId;

    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position positionId;

    @ManyToOne
    @JoinColumn(name = "educationDegreeId")
    private EducationDegree educationDegreeId;

    public Employee() {}

    public Employee(Long employeeId, String employeeName, LocalDate employeeBirthDay, Integer employeeGender, String employeeIdCard, Double employee_salary, String employeePhone, String employeeEmail, String employeeAddress) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthDay = employeeBirthDay;
        this.employeeGender = employeeGender;
        this.employeeIdCard = employeeIdCard;
        this.employee_salary = employee_salary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(LocalDate employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public Integer getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(Integer employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public EducationDegree getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(EducationDegree educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }
}
