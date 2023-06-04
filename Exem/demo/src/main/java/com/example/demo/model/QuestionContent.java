package com.example.demo.model;

import org.hibernate.annotations.Parent;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
public class QuestionContent {
    @Id
    @Column(name = "question_content_id", columnDefinition = "varchar(10)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Không được để trống")
    private String title;
    @NotBlank(message = "Không được để trống")
    private String content;
    @NotBlank(message = "Không được để trống")
    private String answer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "NGay nhap khong hop le")
    private Date dateCreate;
    private boolean status;
    @ManyToOne()
    @JoinColumn(name = "id_question_type",referencedColumnName = "idQuestionType")
    private QuestionType questionType;

    public QuestionContent() {
    }

    public QuestionContent(Long id, String title, String content, String answer, Date dateCreate, boolean status, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.status = status;
        this.questionType = questionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
