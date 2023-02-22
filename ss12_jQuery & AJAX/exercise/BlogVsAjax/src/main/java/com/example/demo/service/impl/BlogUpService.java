package com.example.demo.service.impl;

import com.example.demo.model.BlogUp;
import com.example.demo.model.Category;
import com.example.demo.repository.BlogUpRepository;
import com.example.demo.service.IBlogUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogUpService implements IBlogUpService {
    @Autowired
    private BlogUpRepository repository;
    @Override
    public List<BlogUp> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(BlogUp blogUp) {
        repository.save(blogUp);
    }

    @Override
    public BlogUp findById(Integer id) {
        return repository.findById(id).orElse(new BlogUp());
    }

    @Override
    public Optional<BlogUp> findBlogUpById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void update(BlogUp blogUp) {
        repository.save(blogUp);
    }

    @Override
    public void delete(BlogUp blogUp) {
        repository.delete(blogUp);
    }

    @Override
    public List<BlogUp> findBlogsByCategory(Category category) {
        return repository.findBlogUpsByCategory(category);
    }

    @Override
    public Page<BlogUp> getAllWithPage(PageRequest pageRequest) {
        return repository.findAllWithPage(pageRequest);
    }
}
