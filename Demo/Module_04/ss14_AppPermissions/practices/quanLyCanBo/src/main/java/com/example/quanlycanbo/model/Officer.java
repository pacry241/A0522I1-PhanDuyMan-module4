package com.example.quanlycanbo.model;

public abstract class Officer {
    protected String name;
    protected int age;
    protected int gender;
    protected String address;

    public Officer() {
    }
    public Officer(String name, int age, int gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String a="";
        switch(gender){
            case 1:
                a="Male";
                break;
            case 2:
                a="Female";
                break;
            case 3:
                a="Other";
                break;
        }
        return "Engineer{" +
                "trainingIndustry='" + trainingIndustry + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + a+
                ", address='" + address + '\'' +
                '}';
    }
}
