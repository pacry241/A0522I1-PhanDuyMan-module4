package com.example.demotestmorning.service.impl;

import com.example.demotestmorning.model.Contract;
import com.example.demotestmorning.repository.ContractRepo;
import com.example.demotestmorning.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    ContractRepo contractRepo;

    @Override
    public void create(Contract contract) {
        contractRepo.save(contract);
    }

    @Override
    public Page<Contract> search(Pageable pageable, String searchVal) {
        return contractRepo.findByContractIdContainingOrCustomer_CustomerNameContaining(pageable, searchVal, searchVal);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        contractRepo.deleteById(id);
    }
}
