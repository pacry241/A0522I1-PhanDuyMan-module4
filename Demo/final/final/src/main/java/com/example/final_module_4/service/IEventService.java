package com.example.final_module_4.service;

import com.example.final_module_4.model.Event;

import java.util.Date;
import java.util.List;

public interface IEventService {
    void create(Event event);
    void delete(Long id);
    List<Event> findAll();
    Event finById(Long id);
    List<Event> findByMucGiamGiaContainingAndTgBatDauContainingAndTgKetThucContaining(Double mucGiamGia, Date tgBatDau, Date tgKetThuc);
    List<Event> findByTgBatDauContainingAndTgKetThucContaining(Date tgBatDau,Date tgKetThuc);
}
