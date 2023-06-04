package com.example.imageday.service;

import com.example.imageday.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    void save(Comment comment);
}
