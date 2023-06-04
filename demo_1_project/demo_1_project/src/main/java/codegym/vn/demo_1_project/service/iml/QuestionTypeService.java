package codegym.vn.demo_1_project.service.iml;

import codegym.vn.demo_1_project.model.QuestionType;
import codegym.vn.demo_1_project.repository.IQuestionTypeRepo;
import codegym.vn.demo_1_project.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    IQuestionTypeRepo questionTypeRepo;
    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepo.findAll();
    }
}
