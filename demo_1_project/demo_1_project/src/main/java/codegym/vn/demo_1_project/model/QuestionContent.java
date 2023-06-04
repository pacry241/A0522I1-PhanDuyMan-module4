package codegym.vn.demo_1_project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "question")
public class QuestionContent {
    @Id
    @Column(name = "question_content_id", columnDefinition = "varchar(10)")
    @NotBlank(message = "Không được để trống")
    private String id;
    @NotBlank(message = "Không được để trống")
    private String title;
    @NotBlank(message = "Không được để trống")
    private String content;
    @NotBlank(message = "Không được để trống")
    private String answer;
    private Date dateCreate;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_question_type",referencedColumnName = "idQuestionType")
   private QuestionType questionType;

    public QuestionContent() {
    }

    public QuestionContent(String id, String title, String content, String answer, Date dateCreate, boolean status, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.status = status;
        this.questionType = questionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
