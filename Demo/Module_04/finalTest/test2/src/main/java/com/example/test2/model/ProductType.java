package com.example.test2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    private String nameType;

    @OneToMany(mappedBy = "productType")
    @JsonBackReference
    private Set<Product> products;


    public ProductType(Integer typeId, String nameType, Set<Product> products) {
        this.typeId = typeId;
        this.nameType = nameType;
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public ProductType() {
    }

    public ProductType(Integer typeId, String nameType) {
        this.typeId = typeId;
        this.nameType = nameType;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
