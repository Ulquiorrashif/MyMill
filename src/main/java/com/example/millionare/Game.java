package com.example.millionare;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final List<Question> questions;
    private int currentQuestionIndex;
    private int currentMoney;

    public Game(List<Question> questions) {
        this.questions = questions;
//        this.currentQuestionIndex = 0;
//        this.currentMoney = 0;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }
    public boolean checkPlayerChoice (Question currentQuestion, int playerChoice){
        if (currentQuestion.isCorrect(playerChoice)) {
            setCurrentMoney(getCurrentMoney()+1000);
            System.out.println("Правильно! Вы выиграли " + currentMoney + " рублей.");
            currentQuestionIndex++;
            return true;
        } else {
            setCurrentMoney(0);
            System.out.println("Вы проиграли.");
            return false;
        }
    }

    public void start() {
        setCurrentMoney(0);
        setCurrentQuestionIndex(0);
        Scanner scanner = new Scanner(System.in);
        while (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            currentQuestion.displayQuestion();

            System.out.print("Выберите номер правильного ответа: ");
            int playerChoice = scanner.nextInt();
            if (!checkPlayerChoice(currentQuestion, playerChoice))
                break;


        }
        System.out.println("Игра окончена. Вы выиграли " + currentMoney + " рублей.");
    }

    public int getCurrentMoney() {
        return this.currentMoney;
    }

    public int getCurrentQuestionIndex() {
        return this.currentQuestionIndex;
    }

}
