package com.example.demoretest.dto;


public class SearchSession {
    private String name;
    private String contractType;

    public SearchSession() {
    }

    public SearchSession(String name, String contractType) {
        this.name = name;
        this.contractType = contractType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
}