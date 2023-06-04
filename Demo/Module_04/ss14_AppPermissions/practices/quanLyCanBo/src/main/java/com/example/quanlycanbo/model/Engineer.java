package com.example.quanlycanbo.model;

public class Engineer extends Officer{
    private String trainingIndustry;

    public Engineer() {
    }

    public Engineer(String trainingIndustry) {
        this.trainingIndustry = trainingIndustry;
    }

    public Engineer(String name, int age, int gender, String address, String trainingIndustry) {
        super(name, age, gender, address);
        this.trainingIndustry = trainingIndustry;
    }

    public String getTrainingIndustry() {
        return trainingIndustry;
    }

    public void setTrainingIndustry(String trainingIndustry) {
        this.trainingIndustry = trainingIndustry;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "trainingIndustry='" + trainingIndustry + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
