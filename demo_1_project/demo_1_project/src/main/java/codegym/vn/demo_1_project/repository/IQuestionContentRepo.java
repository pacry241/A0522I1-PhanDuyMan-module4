package codegym.vn.demo_1_project.repository;

import codegym.vn.demo_1_project.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuestionContentRepo extends JpaRepository<QuestionContent,String> {
    Page<QuestionContent> findByTitleContainingAndQuestionType_IdQuestionTypeContaining(String title, String id, Pageable pageable);
}
