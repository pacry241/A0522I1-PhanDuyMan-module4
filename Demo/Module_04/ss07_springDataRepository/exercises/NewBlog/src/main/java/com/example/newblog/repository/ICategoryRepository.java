package com.example.newblog.repository;

import com.example.newblog.model.Blog;
import com.example.newblog.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends CrudRepository<Category, Integer> {

}
