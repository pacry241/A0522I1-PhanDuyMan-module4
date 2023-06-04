package codegym.vn.demo_1_project.service.iml;

import codegym.vn.demo_1_project.model.QuestionContent;
import codegym.vn.demo_1_project.repository.IQuestionContentRepo;
import codegym.vn.demo_1_project.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    IQuestionContentRepo questionContentRepo;

    @Override
    public Page<QuestionContent> findAll(Pageable pageable) {
        return questionContentRepo.findAll(pageable);
    }

    @Override
    public void removeById(String id) {
        questionContentRepo.deleteById(id);
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepo.save(questionContent);
    }

    @Override
    public QuestionContent findById(String id) {
        return questionContentRepo.findById(id).orElse(null);
    }

    @Override
    public Page<QuestionContent> findByTitleContainingAndQuestionType_IdQuestionTypeContaining(String title, String id, Pageable pageable) {
        return questionContentRepo.findByTitleContainingAndQuestionType_IdQuestionTypeContaining(title,id,pageable);
    }
}
