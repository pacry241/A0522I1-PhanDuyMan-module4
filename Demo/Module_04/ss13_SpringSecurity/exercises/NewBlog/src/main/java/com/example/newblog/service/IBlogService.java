package com.example.newblog.service;

import com.example.newblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blog getBlogById(int id);
    List<Blog> findBlogById(int id);
    List<Blog> getList();
    void save(Blog blog);
    void update(Blog blog);
    void deleteBlogById(int id);
    List<Blog> findByName(String nameOrId);
    Page<Blog> findAll(Pageable pageable);
}
