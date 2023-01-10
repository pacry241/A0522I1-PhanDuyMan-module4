package com.example.demo.repository;

import com.example.demo.model.BlogUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogUpRepository extends JpaRepository<BlogUp, Integer> {
//    @Query(value = "select * from blog_up", countName = "select * from blog_up", nativeQuery = true)
//    @Modifying
//    Page<BlogUp> findAllWithPage(PageRequest pageRequest);
}
