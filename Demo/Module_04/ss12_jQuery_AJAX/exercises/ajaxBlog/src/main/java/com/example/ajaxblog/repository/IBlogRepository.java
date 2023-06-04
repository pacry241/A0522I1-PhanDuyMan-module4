package com.example.ajaxblog.repository;

import com.example.ajaxblog.model.Blog;
import com.example.ajaxblog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findBlogsByNameBlog(String nameBlog);

    @Query("Select b from Blog b where b.nameBlog like :nameBlog")
    List<Blog> searchAllByNameBlog(String nameBlog);

    @Query("Select b from Blog b where b.nameBlog = :nameBlog")
    Blog findBlogByName(String nameBlog);

    List<Blog> findAllByCategory(Category category);

    Page<Blog> searchByNameBlog(String name, Pageable pageable);

    Page<Blog> findBlogByNameBlogContaining(String name, Pageable pageable);

    List<Blog> findAllByNameBlogContaining(String name);
}
