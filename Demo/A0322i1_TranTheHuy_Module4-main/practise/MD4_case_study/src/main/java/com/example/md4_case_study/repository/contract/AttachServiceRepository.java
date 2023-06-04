package com.example.md4_case_study.repository.contract;

import com.example.md4_case_study.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService, Long> {
}
