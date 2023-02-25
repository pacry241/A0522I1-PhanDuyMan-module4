package com.example.securityblog.service;

import com.example.securityblog.model.Blog;
import com.example.securityblog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Optional<Blog> findBlogById(Long id);

    void update(Blog blog);

    void delete(Blog blog);

    List<Blog> findBlogsByCategory(Category category);

    Page<Blog> getAllWithPage(PageRequest pageRequest);
}
