package com.example.demo.service.impl;

import com.example.demo.model.QuestionContent;
import com.example.demo.repository.IQuestionContentRepo;
import com.example.demo.service.QuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuestionContentImpl implements QuestionContentService {
    @Autowired
    private IQuestionContentRepo repo;
    @Override
    public Page<QuestionContent> findAll(PageRequest pageRequest) {
        return repo.findAll(pageRequest);
    }

    @Override
    public void removeById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void save(QuestionContent questionContent) {
        repo.save(questionContent);
    }

    @Override
    public QuestionContent findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Page<QuestionContent> findByTitleContainingAndQuestionType_IdQuestionTypeContaining(String title, Integer id, PageRequest pageRequest) {
        return repo.findByTitleContainingAndQuestionType_IdQuestionTypeContaining(title,id,pageRequest);
    }
}
