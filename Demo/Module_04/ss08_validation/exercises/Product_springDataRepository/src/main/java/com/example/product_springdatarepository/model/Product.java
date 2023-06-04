package com.example.product_springdatarepository.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    private String nameProduct;
    @Column(name = "price")
    @Min(100)
    @Max(500)
    private double price;
    @Column(name = "description")
    @NotBlank(message = "Price is mandatory")
    private String description;
    @Column(name = "manufacture")
    @NotBlank(message = "Manufacture is mandatory")
    private String manufacture;
    //@Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    public Product() {
    }

    public Product(int id, String name, float price, String description, String manufacture) {
        this.id = id;
        this.nameProduct = name;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
