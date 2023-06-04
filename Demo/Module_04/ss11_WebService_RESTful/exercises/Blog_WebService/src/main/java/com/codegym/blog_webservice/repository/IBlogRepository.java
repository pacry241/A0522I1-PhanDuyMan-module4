package com.codegym.blog_webservice.repository;

import com.codegym.blog_webservice.model.Blog;
import com.codegym.blog_webservice.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    List<Blog> findBlogsByCategory(Category category);
}
