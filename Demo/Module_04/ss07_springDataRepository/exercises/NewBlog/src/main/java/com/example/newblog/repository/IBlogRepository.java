package com.example.newblog.repository;

import com.example.newblog.model.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {

    List<Blog> findBlogsByNameBlog(String nameBlog);

    @Query("Select b from Blog b where b.nameBlog like :nameBlog")
    List<Blog> searchAllByNameBlog(String nameBlog);

    @Query("Select b from Blog b where b.nameBlog = :nameBlog")
    Blog findBlogByName(String nameBlog);


}
