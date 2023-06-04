package com.example.md4_case_study.repository.service;

import com.example.md4_case_study.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.print.Pageable;

@Repository
@Transactional
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Page<Service> findServiceByServiceNameContainingIgnoreCaseAndStandardRoomContainingIgnoreCase(String name, String roomStandard, PageRequest of);

    Page<Service> findServiceByServiceNameContainingIgnoreCaseAndStandardRoomContainingIgnoreCaseAndServiceTypeId(String name, String roomStandard, Long facilityTypeId, Pageable pageable);

    @Query(value = "select s from service as s", countQuery = "select s from service as s")
    Page<Service> findAllWithPage(Pageable pageable);

    @Query(value = "select s from service as s where upper(s.service_name) like upper(:searchName) and s.rent_type_id = :searchRent and s.service_type_id = :searchType",
            countQuery = "select s from service as s where upper(s.service_name) like upper(:searchName) and s.rent_type_id = :searchRent and s.service_type_id = :searchType",
            nativeQuery = true)
    Page<Service> findAllAndSearch(@Param("searchName") String searchName, @Param("searchRent") String searchRent,
                                   @Param("searchType") String searchType, Pageable pageable);
}
