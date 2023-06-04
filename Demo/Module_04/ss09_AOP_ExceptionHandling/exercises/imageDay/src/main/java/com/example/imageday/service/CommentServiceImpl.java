package com.example.imageday.service;

import com.example.imageday.model.Comment;
import com.example.imageday.repository.CommentRepositoryimpl;
import com.example.imageday.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements ICommentService{
    @Autowired
    private ICommentRepository commentRepositoryimpl;
    @Override
    public List<Comment> findAll() {
        return commentRepositoryimpl.findAll();
    }

    @Override
    public void save(Comment comment) {
        commentRepositoryimpl.save(comment);
    }
}
