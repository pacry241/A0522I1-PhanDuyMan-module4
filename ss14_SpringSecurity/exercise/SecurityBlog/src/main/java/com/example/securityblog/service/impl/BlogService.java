package com.example.securityblog.service.impl;

import com.example.securityblog.model.Blog;
import com.example.securityblog.model.Category;
import com.example.securityblog.repository.BlogRepository;
import com.example.securityblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository repository;
    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Optional<Blog> findBlogById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        repository.delete(blog);
    }

    @Override
    public List<Blog> findBlogsByCategory(Category category) {
        return repository.findBlogsByCategory(category);
    }

    @Override
    public Page<Blog> getAllWithPage(PageRequest pageRequest) {
        return repository.findAllWithPage(pageRequest);
    }
}
