package com.example.securityblog.model;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_category")
    private String nameCategory;

    public Category() {
    }

    public Category(int id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
