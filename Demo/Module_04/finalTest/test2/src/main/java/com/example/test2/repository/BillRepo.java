package com.example.test2.repository;

import com.example.test2.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer> {
    Page<Bill> findByProduct_ProductNameContaining (Pageable pageable, String time);

}
