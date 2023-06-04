package com.example.demoretest.service.contract;

import com.example.demoretest.model.Contract;
import com.example.demoretest.service.IGeneralService;

import java.util.List;

public interface IContractService extends IGeneralService<Contract> {
    @Override
    List<Contract> finAll();

    List<Contract> findAllByName(String name);

    List<Contract> findAllByContractType(String contractType);

    List<Contract> findAll(String contractType, String name);
}
