package com.example.electronicform2.model;

import javax.persistence.Entity;

@Entity
public class Mail {

    private String language;
    private int pageSize;
    private boolean spams;
    private String signature;

}
