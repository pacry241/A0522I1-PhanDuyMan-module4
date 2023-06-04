package com.example.testmodule4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "giao_dich")
public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_GD")
    private Integer maGD;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayGiaoDich;

    private String loaiDichVu;
    private double donGia;
    private double dienTich;

    @OneToMany(mappedBy = "ma_GD  ")
    private Set<KhachHang> khachHangs;


    public GiaoDich() {
    }

    public GiaoDich(Integer maGD, Date ngayGiaoDich, String loaiDichVu, double donGia, double dienTich, Set<KhachHang> khachHangs) {
        this.maGD = maGD;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiDichVu = loaiDichVu;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.khachHangs = khachHangs;
    }

    public Integer getMaGD() {
        return maGD;
    }

    public void setMaGD(Integer maGD) {
        this.maGD = maGD;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public String getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(String loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public Set<KhachHang> getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(Set<KhachHang> khachHangs) {
        this.khachHangs = khachHangs;
    }
}
