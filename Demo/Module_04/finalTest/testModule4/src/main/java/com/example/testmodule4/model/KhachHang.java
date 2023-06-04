package com.example.testmodule4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKH;
    private String ten;
    private String soDienThoai;
    @Email(message = "wrong email syntax!!!")
    private String email;

    @ManyToOne()
    @JoinColumn(name = "ma_GD")
    private GiaoDich giaoDich;

    public KhachHang() {
    }

    public KhachHang(Integer maKH, String ten, String soDienThoai, String email, GiaoDich giaoDich) {
        this.maKH = maKH;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.giaoDich = giaoDich;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GiaoDich getGiaoDich() {
        return giaoDich;
    }

    public void setGiaoDiches(GiaoDich giaoDich) {
        this.giaoDich = giaoDich;
    }
}
