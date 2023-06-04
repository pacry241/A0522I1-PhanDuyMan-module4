package com.example.testmodule4.repository;

import com.example.testmodule4.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*Page<KhachHang> findByTenContainingOrLoaiDichVuContaining(Pageable pageable, String ten, String loaiDichVu);*/
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    Page<KhachHang> findByTenContainingOrGiaoDiches(Pageable pageable, String ten, String loaiDichVu);
}
