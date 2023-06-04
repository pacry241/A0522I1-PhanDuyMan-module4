package com.example.newajaxblog.repository;

import com.example.newajaxblog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {

}
