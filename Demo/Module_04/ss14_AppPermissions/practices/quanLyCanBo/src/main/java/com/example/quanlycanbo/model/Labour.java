package com.example.quanlycanbo.model;

public class Labour extends Officer{
    private int rank;

    public Labour() {
    }

    public Labour(int rank) {
        this.rank = rank;
    }

    public Labour(String name, int age, int gender, String address, int rank) {
        super(name, age, gender, address);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Labour{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
