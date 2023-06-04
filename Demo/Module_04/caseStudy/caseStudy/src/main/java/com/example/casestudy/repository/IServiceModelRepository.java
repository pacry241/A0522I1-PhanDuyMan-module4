package com.example.casestudy.repository;

import com.example.casestudy.model.service_model.ServiceClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceModelRepository  extends JpaRepository<ServiceClass, Integer> {
}
