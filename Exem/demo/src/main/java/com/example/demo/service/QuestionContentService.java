package com.example.demo.service;

import com.example.demo.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface QuestionContentService {
    Page<QuestionContent> findAll(PageRequest pageRequest);

    void removeById(Long id);

    void save(QuestionContent questionContent);

    QuestionContent findById(Long id);
    Page<QuestionContent> findByTitleContainingAndQuestionType_IdQuestionTypeContaining(String title, Integer id, PageRequest pageRequest);
}
