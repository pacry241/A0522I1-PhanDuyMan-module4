package com.example.final_module_4.repository;

import com.example.final_module_4.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IEventRepo extends JpaRepository<Event,Long> {

    List<Event> findByMucGiamGiaContainingAndTgBatDauContainingAndTgKetThucContaining(Double mucGiamGia, Date tgBatDau,Date tgKetThuc);
    List<Event> findByTgBatDauContainingAndTgKetThucContaining(Date tgBatDau,Date tgKetThuc);

}
