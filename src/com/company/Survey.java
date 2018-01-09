package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Survey {
    private String name,
                answers;
    private int score,
            totalScore;
    private File questionInput;
    private Scanner readInput;

    public Survey(String name) throws FileNotFoundException {
        this.name = name;
        this.score = 0;
        this.totalScore = 0;
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

        return question + "\n" + aAnswer + "\n" + bAnswer + "\n" + cAnswer + "\n" + dAnswer;
    }

    public String checkAnswer(String answer){
        answers += answer + ", ";
        totalScore += 3;

        if(answer.equals("a")){
            score += 3;
            return "Thank you :)";
        }else if(answer.equals("b")){
            score += 2;
            return "We will be better next time!";
        }else if(answer.equals("c")){
            score++;
            return "We are sorry";
        }else
            return "at least we tried ;/";
    }

    public boolean endOfSurvey(){
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

    public String getScore() {
        return score + "/" + totalScore;
    }
}
