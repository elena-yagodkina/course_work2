package course2.courseWork.service;

import course2.courseWork.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    void removeAll();

    Question getRandomQuestion();
}
