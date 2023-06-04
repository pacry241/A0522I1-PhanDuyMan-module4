package com.example.test2.service.impl;

import com.example.test2.model.Bill;
import com.example.test2.repository.BillRepo;
import com.example.test2.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService {
    @Autowired
    BillRepo billRepo;
    @Override
    public void create(Bill bill) {
        billRepo.save(bill);
    }

    @Override
    public Page<Bill> search(Pageable pageable, String searchVal) {
        return billRepo.findByProduct_ProductNameContaining(pageable, searchVal);
    }

    @Override
    public Bill findById(Integer id) {
        return billRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        billRepo.deleteById(id);
    }
}
