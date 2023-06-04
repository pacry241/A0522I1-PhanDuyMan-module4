package com.example.testmodule4.repository;

import com.example.testmodule4.model.GiaoDich;
import com.example.testmodule4.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich, Integer> {

}
