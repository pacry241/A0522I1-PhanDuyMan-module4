package com.example.test2.service;

import com.example.test2.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBillService {
    void create (Bill bill);
    Page<Bill> search(Pageable pageable, String searchVal);
    Bill findById(Integer id);
    void delete(Integer id);
}
