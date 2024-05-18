package course2.courseWork.service;

import course2.courseWork.domain.Question;
import course2.courseWork.exception.QuestionNotFoundException;
import course2.courseWork.exception.ThisQuestionAlreadyExistsException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static course2.courseWork.service.DataTest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceTest {
    public QuestionService service = new JavaQuestionService();

    @BeforeEach
    public void setUp() {
        service.add(QUESTION_1, ANSWER_1);
        service.add(QUESTION_2, ANSWER_2);
        service.add(QUESTION_3, ANSWER_3);
    }

    @Test
    void addQuestion() {
        Question expected = new Question("Что такое bytecode java?", "Байт-код Java — набор инструкций, исполняемых виртуальной машиной Java");
        Question actual = service.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    void throwNotFoundException() {
        service.removeAll();
        assertThrows(QuestionNotFoundException.class, () -> service.getRandomQuestion());
    }

    @Test
    void returnRandomQuestion() {
        Question actual = service.getRandomQuestion();
        assertThat(QUESTIONS, hasItems(actual));
    }

    @Test
    void shouldReturnRemovedQuestion() {
        Question expected = new Question(QUESTION_1, ANSWER_1);
        Question actual = service.remove(OBJECT_QUESTION_1);
        assertEquals(expected, actual);
        assertThrows(QuestionNotFoundException.class, () -> service.remove(OBJECT_QUESTION_1));
    }

    @Test
    void shouldReturnAlreadyAddedException() {
        assertThrows(ThisQuestionAlreadyExistsException.class, () -> service.add(QUESTION_1, ANSWER_1));
        assertThrows(ThisQuestionAlreadyExistsException.class, () -> service.add(OBJECT_QUESTION_1));
    }

    @Test
    void returnAlQuestions() {
        Collection<Question> actual = service.getAll();
        assertThat(actual, Matchers.containsInAnyOrder(
                OBJECT_QUESTION_1,
                OBJECT_QUESTION_2,
                OBJECT_QUESTION_3
        ));
    }
}
