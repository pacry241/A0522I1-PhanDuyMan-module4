package com.example.md4_case_study.dto.employee;

import com.example.md4_case_study.model.employee.Division;
import com.example.md4_case_study.model.employee.EducationDegree;
import com.example.md4_case_study.model.employee.Employee;
import com.example.md4_case_study.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EmployeeDto implements Validator {
    @Pattern(regexp = "\"^EM-\\\\d{4}$\"", message = "Employee code is not valid!")
    private Long employeeId;
    @NotBlank(message = "{empty.invalid}")
    @Size(min = 3, max = 45, message = "{size.invalid}")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "{special.invalid}")
    private String employeeName;
    @NotBlank(message = "{empty.invalid}")
    private LocalDate employeeBirthDay;
    @NotBlank(message = "{empty.invalid}")
    private Integer employeeGender;
    @Pattern(regexp = "\"^[1-9]\\\\d{8,11}$\"", message = "Identity card is not valid!")
    @NotBlank(message = "{empty.invalid}")
    private String employeeIdCard;
    @Pattern(regexp = "(?!0$)[0-9]+(?:\\\\.[0-9]+)?",message = "Please enter number!")
    @NotBlank(message = "{empty.invalid}")
    private Double employee_salary;
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",
            message = "The correct phone number format including 10 numbers!")
    @NotBlank(message = "{empty.invalid}")
    private String employeePhone;
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "The wrong email format, please re-enter!")
    @NotBlank(message = "{empty.invalid}")
    private String employeeEmail;
    @Size(min = 5, max = 120, message = "{size.invalid}")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "{special.invalid}")
    @NotBlank(message = "{empty.invalid}")
    private String employeeAddress;

    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    public EmployeeDto() {}

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        LocalDate now = LocalDate.now();
        LocalDate eighteenYear = now.minusYears(18);
        LocalDate hundredYear = now.minusYears(100);
        if (employee.getEmployeeBirthDay() == null) {
            errors.rejectValue("employeeBirthDay", "empty.invalid");
        } else if (employee.getEmployeeBirthDay().compareTo(eighteenYear) > 0 ||
                employee.getEmployeeBirthDay().compareTo(hundredYear) < 0) {
            errors.rejectValue("employeeBirthDay", "invalid");
        }

        if (employee.getEmployeeGender() == null) {
            errors.rejectValue("employeeGender", "empty.invalid");
        } else if (-1 > employee.getEmployeeGender() || employee.getEmployeeGender() > 1) {
            errors.rejectValue("employeeGender", "gender.invalid");
        }
    }
}
