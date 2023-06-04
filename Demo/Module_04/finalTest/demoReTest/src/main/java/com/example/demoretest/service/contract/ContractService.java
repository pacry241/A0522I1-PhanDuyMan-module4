package com.example.demoretest.service.contract;

import com.example.demoretest.model.Contract;
import com.example.demoretest.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractService implements IContractService{
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> finAll() {
        return contractRepository.findAll();
    }

    @Override
    public List<Contract> findAllByName(String name) {
        return contractRepository.findAllByNameCustomer(name);
    }

    @Override
    public List<Contract> findAllByContractType(String contractType) {
        return contractRepository.findAllByContractTypeContaining(contractType);
    }

    @Override
    public List<Contract> findAll(String contractType, String name) {
        return contractRepository.findAllBy(contractType, name);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> finById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        contractRepository.deleteById(id);
    }
}
