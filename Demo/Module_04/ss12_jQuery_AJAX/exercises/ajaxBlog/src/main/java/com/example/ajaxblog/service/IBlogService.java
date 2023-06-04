package com.example.ajaxblog.service;

import com.example.ajaxblog.model.Blog;
import com.example.ajaxblog.model.Category;
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

    List<Blog> findAllByCategory(Category category);
    Page<Blog> searchByNameBlog(String name, Pageable pageable);
    List<Blog> findAllByNameBlogContaining(String name);
}
