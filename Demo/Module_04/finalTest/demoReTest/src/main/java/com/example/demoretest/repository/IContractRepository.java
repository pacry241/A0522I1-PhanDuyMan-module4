package com.example.demoretest.repository;

import com.example.demoretest.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query("SELECT e from Contract e where e.customer.name=?1")
    List<Contract> findAllByNameCustomer(String name);

    @Override
    List<Contract> findAll();

    List<Contract> findByContractTypeContaining(String contractType);

    List<Contract> findAllByContractTypeContaining(String contractType);

    @Query("SELECT e from Contract e WHERE  e.contractType=?1 and e.customer.name=?2")
    List<Contract> findAllBy(String contractType, String name);
}
