package com.codegym.casestudyversion2.repository;

import com.codegym.casestudyversion2.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
