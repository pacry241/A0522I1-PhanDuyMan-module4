package com.example.md4_case_study.repository.customer;

import com.example.md4_case_study.dto.customer.CustomerHaveBooking;
import com.example.md4_case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Optional;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select c.customer_name, c.email from customer as c " +
            "where upper(c.customer_name) like upper(:name) " +
            "and upper(c.email) like upper(:email)")
    Page<Customer> findAllCustomerByNameAndEmail(@Param("name") String name, @Param("email") String email, PageRequest of);

    @Query(value = "select c.customer_name, c.email, c.customerTypeId from customer as c " +
            "where upper(c.customer_name) like upper(:name) " +
            "and upper(c.email) like upper(:email)")
    Page<Customer> findAllCustomerByNameAndEmailAndTypeId(@Param("name") String name, @Param("email") String email,
                                                          @Param("customerTypeId") Long id, PageRequest of);

    @Query(value = "select c from customer as c", countQuery = "select c from customer as c")
    Page<Customer> findAllCWithPage(PageRequest of);

    Optional<Customer> findFirstByCustomerEmailContaining(String email);

    Optional<Customer> findFirstByCustomerPhone(String phone);

    Optional<Customer> findFirstByCustomerIdCard(String idCard);

    @Query(value = "select c.customer_name as nameCustomer,\n" +
            "       s.service_name as nameService,\n" +
            "       con.start_date as startDate,\n" +
            "       con.end_date as endDate,\n" +
            "       GROUP_CONCAT(a.attach_service_name) as nameServiceInclude,\n" +
            "       sum(coalesce(cd.quantity * a.attach_service_cost, 0)) + s.cost as total\n" +
            "from customer as c\n" +
            "         INNER JOIN contract as con ON c.customer_id = con.customer_id\n" +
            "         INNER JOIN service as s ON con.service_id = s.service_id\n" +
            "         LEFT JOIN contract_detail as cd ON con.contract_id = cd.contract_id\n" +
            "         LEFT JOIN attach_service as a ON cd.attach_service_id = a.attach_service_id\n" +
            "GROUP BY con.contract_id",
            countQuery = "SELECT c.customer_name as nameCustomer,\n" +
                    "       s.service_name as nameService,\n" +
                    "       con.start_date as startDate,\n" +
                    "       con.end_date as endDate,\n" +
                    "       GROUP_CONCAT(a.attach_service_name) as nameServiceInclude,\n" +
                    "       sum(coalesce(cd.quantity * a.attach_service_cost, 0)) + s.cost as total\n" +
                    "FROM customer as c\n" +
                    "         INNER JOIN contract as con ON c.customer_id = con.customer_id\n" +
                    "         INNER JOIN service as s ON con.service_id = s.service_id\n" +
                    "         LEFT JOIN contract_detail as cd ON con.contract_id = cd.contract_id\n" +
                    "         LEFT JOIN attach_service as a ON cd.attach_service_id = a.attach_service_id\n" +
                    "GROUP BY con.contract_id"
            , nativeQuery = true)
    Page<CustomerHaveBooking> findAllCustomerHaveBooking(Pageable pageable);
}
