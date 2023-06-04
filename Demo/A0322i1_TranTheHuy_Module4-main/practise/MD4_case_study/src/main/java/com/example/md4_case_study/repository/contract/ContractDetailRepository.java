package com.example.md4_case_study.repository.contract;

import com.example.md4_case_study.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {
    @Query(value = "select cd from contract_detail as cd", countQuery = "select cd from contract_detail as cd")
    Page<ContractDetail> findAllWithPage(PageRequest of);

    Optional<ContractDetail> findFirstByContractIdAndAttachServiceId(Long contractId, Long attachServiceId);
}

