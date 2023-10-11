package com.example.millionare;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        Question q1 = new Question("Буква 'C' в химии это ?", new String[]{"Азот","Углерод","Водород","Кислород"}, 2);
        Question q2 = new Question("Сколько месяцев в году имеют 28 дней ?", new String[]{"5","1","12","3"}, 3);
        questions.add(q1);
        questions.add(q2);
        Game game = new Game(questions);
        game.start();
    }
}
