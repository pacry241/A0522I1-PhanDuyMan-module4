package com.example.demotest.service.impl;

import com.example.demotest.model.Bill;
import com.example.demotest.repository.IBillRepository;
import com.example.demotest.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository billRepository;


    @Override
    public void Update(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        billRepository.deleteById(id);
    }

    @Override
    public void Save(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Bill findById(Integer id) {
        return billRepository.findById(id).get();
    }

    @Override
    public Page<Bill> getByKeyword(String keyword, Pageable pageable) {
        return billRepository.findByKeyword(keyword, pageable);
    }

}
