package com.example.demo.service.impl;

import com.example.demo.model.QuestionType;
import com.example.demo.repository.IQuestionTypeRepo;
import com.example.demo.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTyoeServiceImpl implements QuestionTypeService {
    @Autowired
     private IQuestionTypeRepo questionTypeRepo;
    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepo.findAll();
    }
}
