package com.example.millionare;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuestionTest {

    @Test
    public void testIsCorrect() {
        String questionText = "Какой язык программирования используется для написания Java?";
        String[] options = {"C++", "Python", "Java", "Ruby"};
        int correctOption = 2;
        Question question = new Question(questionText, options, correctOption);
        assertTrue(question.isCorrect(2)); // Ожидается правильный ответ
        assertFalse(question.isCorrect(1)); // Ожидается неправильный ответ
    }
}

