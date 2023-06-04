package com.codegym.blog_webservice.repository;

import com.codegym.blog_webservice.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
    @Query(value = "select b.idBlog, b.nameBlog, b.title, b.content" +
            "from category as c join blog as b on c.categoryId = b.idBlog where c.categoryId=?1", nativeQuery = true)
    List<Category> findBlogsByCategory(Long id);
}
