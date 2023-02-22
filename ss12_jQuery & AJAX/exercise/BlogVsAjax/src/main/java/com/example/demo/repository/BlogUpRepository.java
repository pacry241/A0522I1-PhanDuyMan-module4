package com.example.demo.repository;

import com.example.demo.model.BlogUp;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogUpRepository extends JpaRepository<BlogUp, Integer> {
    @Query(value = "select * from blog_up", nativeQuery = true)
    Page<BlogUp> findAllWithPage(PageRequest pageRequest);

    List<BlogUp> findBlogUpsByCategory(Category category);
}
