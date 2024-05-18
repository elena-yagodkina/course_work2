package course2.courseWork.service;

import course2.courseWork.domain.Question;

import java.util.List;

public class DataTest {
    public static final String QUESTION_1 = "Что такое классы в Java простыми словами?";
    public static final String QUESTION_2 = "Что такое экземпляр класса Java?";
    public static final String QUESTION_3 = "Что такое Jdk и Jre?";

    public static final String ANSWER_1 = "Класс в Java - это шаблон для создания объекта";
    public static final String ANSWER_2 = "Созданные объекты называют объектом класса или экземпляром класса";
    public static final String ANSWER_3 = "JDK – это программный слой над JRE, который содержит компилятор, отладчик и другие инструменты, обычно встречающиеся в любой среде разработки программного обеспечения";

    public static final Question OBJECT_QUESTION_1 = new Question(QUESTION_1, ANSWER_1);
    public static final Question OBJECT_QUESTION_2 = new Question(QUESTION_2, ANSWER_2);
    public static final Question OBJECT_QUESTION_3 = new Question(QUESTION_3, ANSWER_3);

    public static final List<Question> QUESTIONS = List.of(OBJECT_QUESTION_1, OBJECT_QUESTION_2, OBJECT_QUESTION_3);

}
