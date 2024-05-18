package course2.courseWork.service;

import course2.courseWork.domain.Question;
import course2.courseWork.exception.AmountOfQuestionsMoreThenCollectionHas;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static course2.courseWork.service.DataTest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestionsTest() {
        when(javaQuestionService.getAll()).thenReturn(QUESTIONS);
        when(javaQuestionService.getRandomQuestion()).thenReturn(OBJECT_QUESTION_1, OBJECT_QUESTION_2, OBJECT_QUESTION_3);
        Collection<Question> actual = examinerService.getQuestions(3);
        assertThat(actual, hasItems(OBJECT_QUESTION_1, OBJECT_QUESTION_2, OBJECT_QUESTION_3));
    }

    @Test
    void returnAmountOfQuestionsMoreThenCollectionHas() {
        assertThrows(AmountOfQuestionsMoreThenCollectionHas.class, () -> examinerService.getQuestions(3));
    }
}
