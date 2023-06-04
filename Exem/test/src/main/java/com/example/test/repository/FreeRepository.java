package com.example.test.repository;

import com.example.test.model.ServiceFree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeRepository extends JpaRepository<ServiceFree, Long> {
    @Query(value = "select*from service_free", countQuery = "select*from service_free",nativeQuery = true)
    Page<ServiceFree> findAllWithPage(PageRequest pageRequest);

    @Query(value = "select*from service_free where count_down=?1", countQuery = "select*from service_free where count_down=?1", nativeQuery = true)
    Page<ServiceFree> findAllByCountDown(Long countDown, PageRequest pageRequest);

    Page<ServiceFree> findByNameServiceContainingAndCountDownContainingAndDescriptionFreeContaining(String name, Long count, String description, PageRequest pageRequest);
    Page<ServiceFree> findByNameServiceOrAndDescriptionFree(String keyword,String keyword2,PageRequest pageRequest);
}
