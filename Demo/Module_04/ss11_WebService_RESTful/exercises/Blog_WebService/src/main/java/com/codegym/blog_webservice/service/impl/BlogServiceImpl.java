package com.codegym.blog_webservice.service.impl;

import com.codegym.blog_webservice.model.Blog;
import com.codegym.blog_webservice.model.Category;
import com.codegym.blog_webservice.repository.IBlogRepository;
import com.codegym.blog_webservice.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findBlogsByCategory(Category category) {
        return blogRepository.findBlogsByCategory(category);
    }
}
