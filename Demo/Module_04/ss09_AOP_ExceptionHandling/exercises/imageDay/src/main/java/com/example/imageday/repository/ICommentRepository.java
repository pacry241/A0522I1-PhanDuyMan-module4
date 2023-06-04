package com.example.imageday.repository;
import com.example.imageday.model.Comment;
import java.util.List;

public interface ICommentRepository {
    List<Comment> findAll();
    void save(Comment comment);
}
