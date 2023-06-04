package com.example.testmodule4.service;

import com.example.testmodule4.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IKhachHangService {
    void create(KhachHang khachHang);
    void update(KhachHang khachHang);
    void delete(Integer id);
    KhachHang findById(Integer id);
    Page<KhachHang> findAndPaging(Pageable pageable);
    List<KhachHang> findAll();
    Page<KhachHang> searchByNameOrDichVu(Pageable pageable, String searchVal);
}
