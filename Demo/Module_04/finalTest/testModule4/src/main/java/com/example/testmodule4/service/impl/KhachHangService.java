package com.example.testmodule4.service.impl;

import com.example.testmodule4.model.KhachHang;
import com.example.testmodule4.repository.KhachHangRepository;
import com.example.testmodule4.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService {

    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public void create(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void delete(Integer id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang findById(Integer id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public Page<KhachHang> findAndPaging(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public Page<KhachHang> searchByNameOrDichVu(Pageable pageable, String searchVal) {
        return khachHangRepository.findByTenContainingOrGiaoDiches(pageable,searchVal,searchVal);
    }
}
