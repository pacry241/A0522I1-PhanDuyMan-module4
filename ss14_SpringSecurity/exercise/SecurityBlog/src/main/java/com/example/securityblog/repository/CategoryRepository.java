package com.example.securityblog.repository;

import com.example.securityblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "select b.id,b.author,b.note,b.time from blog_up b join category c on b.id_category = c.id where c.id = ?1", nativeQuery = true)
    List<Category> findBlogUpsByCategory(Integer id);
}
