package com.codegym.casestudyversion2.repository;

import com.codegym.casestudyversion2.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer", countQuery = "select * from customer", nativeQuery = true)
    Page<Customer> findAllWithPage(PageRequest of);

    Page<Customer> findAllByCustomerNameContainingOrAndCustomerPhoneContainingOrAndCustomerEmailContaining(String name, String phone, String email, PageRequest of);

    @Query(value = "select * from customer c where c.customer_name like :name or c.phone_number like :phone or c.email like :email",
            nativeQuery = true)
    Page<Customer> findAllWithRequirement(String name, String phone, String email, Pageable of);

//    countQuery = "select count(*) from customer c where c.customer_name like %:name% or c.email like %:phone% or c.phone_number like %:email%"
    Customer findFirstByCustomerEmail(String email);

    Customer findFirstByCustomerPhone(String phone);

    Customer findFirstByCustomerIdCard(String idCard);

    Customer findFirstByCustomerId(String customerCode);
}
