package codegym.vn.demo_1_project.repository;

import codegym.vn.demo_1_project.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionTypeRepo extends JpaRepository<QuestionType,String> {
}
