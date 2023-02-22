package com.example.final_module_4.service;

import com.example.final_module_4.model.Event;
import com.example.final_module_4.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class EventService implements IEventService{
    @Autowired
    IEventRepo eventRepo;
    @Override
    public void create(Event event) {
        eventRepo.save(event);
    }

    @Override
    public void delete(Long id) {
        eventRepo.deleteById(id);
    }

    @Override
    public List<Event> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Event finById(Long id) {
        return eventRepo.findById(id).orElse(null);
    }

    @Override
    public List<Event> findByMucGiamGiaContainingAndTgBatDauContainingAndTgKetThucContaining(Double mucGiamGia, Date tgBatDau, Date tgKetThuc) {
        return eventRepo.findByMucGiamGiaContainingAndTgBatDauContainingAndTgKetThucContaining(mucGiamGia,tgBatDau,tgKetThuc);
    }

    @Override
    public List<Event> findByTgBatDauContainingAndTgKetThucContaining(Date tgBatDau, Date tgKetThuc) {
        return eventRepo.findByTgBatDauContainingAndTgKetThucContaining(tgBatDau,tgKetThuc);
    }


}
