package com.example.blogweb.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
