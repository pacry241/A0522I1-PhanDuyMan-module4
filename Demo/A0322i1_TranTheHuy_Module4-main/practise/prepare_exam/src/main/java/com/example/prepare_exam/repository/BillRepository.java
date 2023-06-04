package com.example.prepare_exam.repository;

import com.example.prepare_exam.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "SELECT * FROM Bill b where b.quantity like %?1% or b.description like %?1%",
            countQuery = "SELECT * FROM Bill b where b.quantity like %?1% or b.description like %?1%", nativeQuery = true)
    Page<Bill> findAllByRequirement(@Param("keyword") String keyword, Pageable pageable);

}

//countQuery = "select * from bill b where b.quantity like :keyword or b.description :keyword"