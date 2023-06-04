package com.example.demotestmorning.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 5, max = 45, message = "asgbhvab")
    private String contractId;

    private boolean contractType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractTime;

    @Min(value = 500000, message = "Price least must be bigger than 500000")
    private double price;

    @Min(value = 20, message = "Area least must be bigger than 20 (m2)")
    private double area;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "customer_customerId")
    private Customer customer;

    public Contract(Integer id, String contractId, boolean contractType, Date contractTime, double price, double area, Customer customer) {
        this.id = id;
        this.contractId = contractId;
        this.contractType = contractType;
        this.contractTime = contractTime;
        this.price = price;
        this.area = area;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Contract(Integer id, String contractId, boolean contractType, Date contractTime, double price, double area) {
        this.id = id;
        this.contractId = contractId;
        this.contractType = contractType;
        this.contractTime = contractTime;
        this.price = price;
        this.area = area;
    }

    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public boolean isContractType() {
        return contractType;
    }

    public void setContractType(boolean contractType) {
        this.contractType = contractType;
    }

    public Date getContractTime() {
        return contractTime;
    }

    public void setContractTime(Date contractTime) {
        this.contractTime = contractTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
