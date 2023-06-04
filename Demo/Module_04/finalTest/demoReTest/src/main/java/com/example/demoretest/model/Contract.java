package com.example.demoretest.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String contractType;

    @Min(500001)
    private Double price;

    @Min(21)
    private Double area;

    @ManyToOne
    private Customer customer;

    public Contract(Integer id, Date date, String contractType, Double price, Double area, Customer customer) {
        this.id = id;
        this.date = date;
        this.contractType = contractType;
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

    public Contract() {
    }

    public Contract(Integer id, Date date, String contractType, Double price, Double area) {
        this.id = id;
        this.date = date;
        this.contractType = contractType;
        this.price = price;
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
