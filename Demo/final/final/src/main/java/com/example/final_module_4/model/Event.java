package com.example.final_module_4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Không được để trống")
    private String tieuDe;
//    @NotNull(message = "Vui lòng chọn ngày bắt đầu")
    private Date tgBatDau;
//    @NotNull(message = "Vui lòng chọn ngày kết thúc")
    private Date tgKetThuc;
    @Min(value = 10000, message = "Mức khuyến mãi phải lớn hơn 10.000VNĐ")
    private double mucGiamGia;
    @NotBlank(message = "vui lòng nhập chi tiết")
    private String chiTiet;


    public Event() {
    }

    public Event(Long id, String tieuDe, Date tgBatDau, Date tgKetThuc, double mucGiamGia, String chiTiet) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.mucGiamGia = mucGiamGia;
        this.chiTiet = chiTiet;
    }

    public double getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(double mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public Date getTgBatDau() {
        return tgBatDau;
    }

    public void setTgBatDau(Date tgBatDau) {
        this.tgBatDau = tgBatDau;
    }

    public Date getTgKetThuc() {
        return tgKetThuc;
    }

    public void setTgKetThuc(Date tgKetThuc) {
        this.tgKetThuc = tgKetThuc;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }
}
