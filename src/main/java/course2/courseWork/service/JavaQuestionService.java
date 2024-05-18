package course2.courseWork.service;

import course2.courseWork.domain.Question;
import course2.courseWork.exception.QuestionNotFoundException;
import course2.courseWork.exception.ThisQuestionAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        boolean newQuestion = questions.add(q);
        if (!newQuestion) {
            throw new ThisQuestionAlreadyExistsException("Такой вопрос уже существует");
        }
        return (q);
    }

    @Override
    public Question add(Question question) {
        boolean newQuestion = questions.add(question);
        if (!newQuestion) {
            throw new ThisQuestionAlreadyExistsException("Такой вопрос уже существует");
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        Iterator<Question> i = questions.iterator();
        Question next;
        while (i.hasNext()) {
            next = i.next();
            if (next.getQuestion().equals(question.getQuestion()) && next.getAnswer().equals(question.getAnswer())) {
                i.remove();
                return question;
            }
        }
        throw new QuestionNotFoundException("Такого вопроса нет в списке");
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public void removeAll() {
        questions.clear();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        if (!questions.isEmpty()) {
            List<Question> questionList = new ArrayList<>(questions);
            return questionList.get(random.nextInt(questions.size()));
        }
        throw new QuestionNotFoundException("В списке нет вопросов");
    }
}
