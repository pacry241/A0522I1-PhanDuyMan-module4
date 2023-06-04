package com.example.demo.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_product", columnDefinition = "varchar(50)")
    private String name;

    @ColumnDefault("0.0")
    private Double price;

    @ColumnDefault("0.0")
    private Double weight;

    @Column(columnDefinition = "varchar(150)")
    private String description;

    @Column(columnDefinition = "varchar(5000)")
    private String imageName;

    @ColumnDefault("1")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Product() {}

    public Product(Long id, String name, Double price, Double weight, String description, String imageName, Integer status, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.description = description;
        this.imageName = imageName;
        this.status = status;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
