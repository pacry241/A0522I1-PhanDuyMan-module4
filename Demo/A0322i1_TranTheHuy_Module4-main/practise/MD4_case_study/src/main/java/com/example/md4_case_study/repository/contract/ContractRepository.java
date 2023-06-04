package com.example.md4_case_study.repository.contract;

import com.example.md4_case_study.dto.contract.ServiceAttachInContract;
import com.example.md4_case_study.dto.customer.CustomerHaveBooking;
import com.example.md4_case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface ContractRepository extends JpaRepository<Contract, Long> {
    @Query(value = "select c from contract as c", countQuery = "select c from contract as c")
    Page<Contract> findAllWithPage(PageRequest of);

    @Query(value = "SELECT a.attach_service_name as attachServiceName,\n" +
            "       a.attach_service_cost as attachServiceCost,\n" +
            "       a.attach_service_unit as attachServiceUnit,\n" +
            "       cd.quantity as quantity,\n" +
            "       (cd.quantity * a.attach_service_cost) as total\n" +
            "FROM contract_detail as cd\n" +
            "         INNER JOIN attach_service as a ON cd.attach_service_id = a.attach_service_id\n" +
            "WHERE cd.contract_id = :id")
    List<ServiceAttachInContract> findDetailByContract(@Param("id") Long id);

    @Query(value = "SELECT con.contract_id as contractId,\n" +
            "       c.customer_name as customerName,\n" +
            "       s.service_name as serviceName,\n" +
            "       con.start_date as startDate,\n" +
            "       con.end_date as endDate,\n" +
            "       con.contract_deposit as deposit,\n" +
            "       sum(coalesce(cd.quantity * a.attach_service_cost, 0)) + f.cost as total,\n" +
            "       GROUP_CONCAT(a.attach_service_name) as nameServiceAttach\n" +
            "FROM customer c\n" +
            "         INNER JOIN contract con ON c.customer_id = con.customer_id\n" +
            "         INNER JOIN service s ON con.service_id = s.service_id\n" +
            "         LEFT JOIN contract_detail cd ON con.contract_id = cd.contract_id\n" +
            "         LEFT JOIN attach_service a ON cd.attach_service_id = a.attach_service_id\n" +
            "WHERE con.start_date BETWEEN :startBegin AND :startEnd AND con.end_date BETWEEN :endBegin AND :end\n" +
            "GROUP BY con.contract_id, c.customer_name",
            countQuery = "SELECT con.contract_id as contractId,\n" +
                    "       c.customer_name as customerName,\n" +
                    "       s.service_name as serviceName,\n" +
                    "       con.start_date as startDate,\n" +
                    "       con.end_date as endDate,\n" +
                    "       con.contract_deposit as deposit,\n" +
                    "       sum(coalesce(cd.quantity * a.attach_service_cost, 0)) + f.cost as total,\n" +
                    "       GROUP_CONCAT(a.attach_service_name) as nameServiceAttach\n" +
                    "FROM customer c\n" +
                    "         INNER JOIN contract con ON c.customer_id = con.customer_id\n" +
                    "         INNER JOIN service s ON con.service_id = s.service_id\n" +
                    "         LEFT JOIN contract_detail cd ON con.contract_id = cd.contract_id\n" +
                    "         LEFT JOIN attach_service a ON cd.attach_service_id = a.attach_service_id\n" +
                    "WHERE con.start_date BETWEEN :startBegin AND :startEnd AND con.end_date BETWEEN :endBegin AND :end\n" +
                    "GROUP BY con.contract_id, c.customer_name")
    Page<CustomerHaveBooking> findAllContractAndDetail(@Param("startBegin") LocalDateTime startBegin,
                                                       @Param("startEnd") LocalDateTime startEnd,
                                                       @Param("endBegin") LocalDateTime endBegin,
                                                       @Param("end") LocalDateTime end,
                                                       Pageable pageable);
}
