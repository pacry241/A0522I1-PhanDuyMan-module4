package com.example.quanlycanbo.model;

public class Staff extends Officer{
    private String work;

    public Staff() {
    }

    public Staff(String work) {
        this.work = work;
    }

    public Staff(String name, int age, int gender, String address, String work) {
        super(name, age, gender, address);
        this.work = work;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "work='" + work + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
