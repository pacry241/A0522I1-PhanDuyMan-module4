package codegym.vn.demo_1_project.model;

import javax.persistence.*;

@Entity
@Table(name = "question_type")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idQuestionType;
    private String name;


    public QuestionType() {
    }

    public QuestionType(String idQuestionType, String name) {
        this.idQuestionType = idQuestionType;
        this.name = name;
    }

    public String getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(String idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
