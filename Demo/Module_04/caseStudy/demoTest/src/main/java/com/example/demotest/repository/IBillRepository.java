package com.example.demotest.repository;

import com.example.demotest.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {

    @Query(value = "SELECT * FROM Bill b where b.quantity like %:keyword% or b.description like %:keyword%",
            countQuery = "SELECT * FROM Bill b where b.quantity like %:keyword% or b.description like %:keyword%",nativeQuery = true)
    Page<Bill> findByKeyword(@Param("keyword") String keyword, Pageable pageable);

   /* @Query(value = "select * from bill s where s.quantity like %:keyword% or s.description like %:keyword%", nativeQuery = true)
    Page<Bill> findByKeyword(@Param("keyword") String keyword, Pageable pageable);*/
}
