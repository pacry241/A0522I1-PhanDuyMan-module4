package com.example.demo.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User  implements Validator{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;
    @NotEmpty
    @Size(min = 5, max = 45)
    @Column(name = "firstName")
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    @Column(name = "lastName")
    private String lastName;

    @Size(min = 1, message = "whatever")
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$")
    @Column(name = "phone")
    private String phoneNumber;

    @Min(value = 18)
    @Column(name = "age")
    private int age;

    @Email
    @NotEmpty
    @Column(name = "email")
    private String email;


    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
