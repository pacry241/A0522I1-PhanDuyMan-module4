package codegym.vn.demo_1_project.service;

import codegym.vn.demo_1_project.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionContentService {
    Page<QuestionContent> findAll(Pageable pageable);

    void removeById(String id);

    void save(QuestionContent questionContent);

    QuestionContent findById(String id);
    Page<QuestionContent> findByTitleContainingAndQuestionType_IdQuestionTypeContaining(String title, String id, Pageable pageable);
}
