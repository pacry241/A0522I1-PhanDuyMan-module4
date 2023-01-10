package com.example.demo.model;

import javax.persistence.*;

@Entity
public class BlogUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "author")
    private String author;
    @Column(name = "note")
    private String description;
    @Column(name = "time",columnDefinition = "date")
    private String time;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public BlogUp() {
    }

    public BlogUp(Integer id, String author, String description) {
        this.id = id;
        this.author = author;
        this.description = description;
    }

    public BlogUp(Integer id, String author, String description, String time, Category category) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.time = time;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
