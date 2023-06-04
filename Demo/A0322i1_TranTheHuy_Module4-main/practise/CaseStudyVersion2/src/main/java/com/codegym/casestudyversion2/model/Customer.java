package com.codegym.casestudyversion2.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "customer_name", columnDefinition = "varchar(50)")
    private String customerName;

    @Column(name = "date_of_birth")
    private LocalDate customerBirthDay;

    @Column(name = "gender")
    private Integer customerGender;

    @Column(name = "identity_card", columnDefinition = "varchar(50)")
    private String customerIdCard;

    @Column(name = "phone_number", columnDefinition = "varchar(20)")
    private String customerPhone;

    @Column(name = "email", columnDefinition = "varchar(50)")
    private String customerEmail;

    @Column(name = "address", columnDefinition = "varchar(150)")
    private String customerAddress;
    @ManyToOne
    @JoinColumn(name = "customerTypeId")
    private CustomerType customerTypeId;

    public Customer() {}

    public Customer(Long customerId, String customerName, LocalDate customerBirthDay, Integer customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerTypeId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerTypeId = customerTypeId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(LocalDate customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
