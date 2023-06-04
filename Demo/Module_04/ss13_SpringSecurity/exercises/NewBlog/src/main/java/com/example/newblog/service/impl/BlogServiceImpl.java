package com.example.newblog.service.impl;

import com.example.newblog.model.Blog;
import com.example.newblog.repository.IBlogRepository;
import com.example.newblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Blog getBlogById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findBlogById(int id) {
        Optional<Blog> optionalBlog = iBlogRepository.findById(id); //Iterable: dùng để sắp xếp;
        List<Blog> blogList = new ArrayList<>();
        for (Blog b: blogList) {
            blogList.add(b);
        }
        return blogList;
    }

    @Override
    public List<Blog> getList() {
        Iterable<Blog> iterable = iBlogRepository.findAll(); //Iterable: dùng để sắp xếp;
        List<Blog> blogListList = new ArrayList<>();
        for (Blog b: iterable) {
            blogListList.add(b);
        }
        return blogListList;
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByName(String nameOrId) {
        return iBlogRepository.findBlogsByNameBlog(nameOrId);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }
}
