package com.example.millionare;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class GameTest {

    private Game game;
    private List<Question> questions;

    @BeforeEach
    public void setUp() {
        questions = new ArrayList<>();
        // Создайте вопросы и добавьте их в список questions
        questions.add(new Question("Вопрос 1", new String[]{"A", "B", "C", "D"}, 2));
        questions.add(new Question("Вопрос 2", new String[]{"A", "B", "C", "D"}, 3));
        game = new Game(questions);
    }

    @Test
    public void testGameStartWithZeroMoney() {

        game.start();
        assertEquals(0, game.getCurrentMoney());
    }

    @Test
    public void testGameStartWithFirstQuestion() {
        game.start();
        assertEquals(0, game.getCurrentQuestionIndex());
    }

    @Test
    public void testGameCorrectAnswerChangesMoney() {
        // Создайте вопросы и добавьте их в список questions
        Question q1 = new Question("Вопрос 1", new String[]{"A", "B", "C", "D"}, 2);
        Question q2 = new Question("Вопрос 2", new String[]{"A", "B", "C", "D"}, 3);
        questions.add(q1);
        questions.add(q2);

        assertTrue(game.checkPlayerChoice(q1,2)); // Правильный ответ на первый вопрос
        assertEquals(1000, game.getCurrentMoney()); // Проверяем начисление денег

        assertTrue(game.checkPlayerChoice(q2,3)); // Правильный ответ на второй вопрос
        assertEquals(2000, game.getCurrentMoney());
    }

    @Test
    public void testGameCorrectAnswerChangesIndex() {
        // Создайте вопросы и добавьте их в список questions
        Question q1 = new Question("Вопрос 1", new String[]{"A", "B", "C", "D"}, 2);
        Question q2 = new Question("Вопрос 2", new String[]{"A", "B", "C", "D"}, 3);
        questions.add(q1);
        questions.add(q2);

        assertTrue(game.checkPlayerChoice(q1,2)); // Правильный ответ на первый вопрос
        assertEquals(1, game.getCurrentQuestionIndex()); // Проверяем переход к следующему вопросу

        assertTrue(game.checkPlayerChoice(q2,3)); // Правильный ответ на второй вопрос
        assertEquals(2, game.getCurrentQuestionIndex());
    }

    @Test
    public void testGameWrongAnswerEndsGame() {
        Question q1 = new Question("Вопрос 1", new String[]{"A", "B", "C", "D"}, 2);
        questions.add(q1);

        assertFalse(game.checkPlayerChoice(q1,1)); // Неправильный ответ
        assertEquals(0, game.getCurrentMoney()); // Игра завершается с 0 денег
    }
}

