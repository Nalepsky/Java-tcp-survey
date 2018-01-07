package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz {
    private String name,
                correctAnswer,
                answers;
    private int score;
    private File questionInput;
    private Scanner readInput;

    public Quiz(String name) throws FileNotFoundException {
        this.name = name;
        this.score = 0;
        this.answers = "";
        this.questionInput = new File("questions.txt");
        this.readInput = new Scanner(questionInput);
    }

    public String getNextQuestion(){

        if(!readInput.hasNextLine())
            return "";

        String question = readInput.nextLine();
        String  aAnswer = readInput.nextLine();
        String  bAnswer = readInput.nextLine();
        String  cAnswer = readInput.nextLine();
        String  dAnswer = readInput.nextLine();
        correctAnswer = readInput.nextLine();

        return question + "\n" + aAnswer + "\n" + bAnswer + "\n" + cAnswer + "\n" + dAnswer;
    }

    public String checkAnswer(String answer){
        answers += answer + ", ";

        if(answer.equals(correctAnswer)){
            score++;
            return "you have chosen wisely!";
        }
            return "you have chosen poorly!";
    }

    public boolean endOfQuiz(){
        if (readInput.hasNextLine())
            return false;
        return true;
    }

    public String answersSummary(){
        return name + ": " + answers;
    }

    public String scoreSummary(){
        return name + ": " + score;
    }

    public int getScore() {
        return score;
    }
}
