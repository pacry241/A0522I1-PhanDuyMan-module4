package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionType {
    @Id
    private Integer idQuestionType;
    private String name;


    public QuestionType() {
    }

    public QuestionType(Integer idQuestionType, String name) {
        this.idQuestionType = idQuestionType;
        this.name = name;
    }

    public Integer getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(Integer idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}