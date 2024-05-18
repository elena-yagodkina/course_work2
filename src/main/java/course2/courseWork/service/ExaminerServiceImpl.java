package course2.courseWork.service;

import course2.courseWork.domain.Question;
import course2.courseWork.exception.AmountOfQuestionsMoreThenCollectionHas;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= questionService.getAll().size()) {
            Collection<Question> questions = new HashSet<>();
            while (amount != questions.size()) {
                questions.add(questionService.getRandomQuestion());
            }
            return questions;
        } else {
            throw new AmountOfQuestionsMoreThenCollectionHas("Запрошено большее количество вопросов, чем хранится в сервисе");
        }
    }
}
