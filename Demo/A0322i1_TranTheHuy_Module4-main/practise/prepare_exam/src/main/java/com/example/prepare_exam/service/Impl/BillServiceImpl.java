package com.example.prepare_exam.service.Impl;

import com.example.prepare_exam.model.Bill;
import com.example.prepare_exam.repository.BillRepository;
import com.example.prepare_exam.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository repository;

    @Override
    public void update(Bill bill) {
        this.repository.save(bill);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public void save(Bill bill) {
        this.repository.save(bill);
    }

    @Override
    public Bill findById(Integer id) {
        Bill bill = this.repository.findById(id).orElse(null);
        if (bill == null) {
            throw new RuntimeException();
        }
        return bill;
    }

    @Override
    public Page<Bill> findAllByRequirement(String keyword, Pageable pageable) {
        return this.repository.findAllByRequirement(keyword, pageable);
    }


}
