package com.example.securityblog.repository;

import com.example.securityblog.model.Blog;
import com.example.securityblog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Query(value = "select * from blogs", nativeQuery = true)
    Page<Blog> findAllWithPage(PageRequest pageRequest);

    List<Blog> findBlogsByCategory(Category category);
}
