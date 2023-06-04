package com.example.demotestmorning.service;

import com.example.demotestmorning.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    void create (Contract contract);
    Page<Contract> search(Pageable pageable,String searchVal);
    Contract findById(Integer id);
    void delete(Integer id);
}
