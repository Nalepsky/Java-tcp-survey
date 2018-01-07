package com.company;

public class QuizQuestion {
    private String question,
                    aAnswer,
                    bAnswer,
                    cAnswer,
                    dAnswer,
                    correctAnswer;

    public QuizQuestion(String question, String aAnswer, String bAnswer,
                          String cAnswer, String dAnswer, String correctAnswer) {
        this.question = question;
        this.aAnswer = aAnswer;
        this.bAnswer = bAnswer;
        this.cAnswer = cAnswer;
        this.dAnswer = dAnswer;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkIfAnswerIsCorrect(String answer){
        return answer == correctAnswer;
    }
}
