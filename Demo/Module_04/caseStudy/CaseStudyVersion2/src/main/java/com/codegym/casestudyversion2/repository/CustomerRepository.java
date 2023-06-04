package com.codegym.casestudyversion2.repository;

import com.codegym.casestudyversion2.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer", countQuery = "select * from customer", nativeQuery = true)
    Page<Customer> findAllWithPage(PageRequest of);

    Page<Customer> findAllByCustomerNameContainingOrAndCustomerPhoneContainingOrAndCustomerEmailContaining(String name, String phone, String email, PageRequest of);

    @Query(value = "select c from customer as c where c.customerName like :name " +
            "or c.customerPhone like :phone or c.customerEmail like :email",
            countQuery = "select * from customer as c where c.customerName like :name " +
                    "or c.customerPhone like :phone or c.customerEmail like :email", nativeQuery = true)
    Page<Customer> findAllWithRequirement(@Param("name") String name, @Param("phone") String phone,
                                          @Param("email") String email, PageRequest of);

    Customer findFirstByCustomerEmail(String email);

    Customer findFirstByCustomerPhone(String phone);

    Customer findFirstByCustomerIdCard(String idCard);

    Customer findFirstByCustomerId(String customerCode);
}
