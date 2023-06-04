package com.example.demo.repository;

import com.example.demo.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionContentRepo extends JpaRepository<QuestionContent, Long> {
    Page<QuestionContent> findByTitleContainingAndQuestionType_IdQuestionTypeContaining(String title, Integer id, PageRequest pageRequest);
}
