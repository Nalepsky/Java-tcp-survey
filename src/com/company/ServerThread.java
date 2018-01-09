package com.company;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread  {
    private Socket serverSocket;
    private String dataIn;
    private String dataOut;
    private Survey quiz;
    private boolean firstDataFlag;

    public ServerThread(Socket serverSocket) {
        this.serverSocket = serverSocket;
        this.firstDataFlag = true;
    }

    public void run() {

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintStream serverRespond = new PrintStream(serverSocket.getOutputStream());

            while (true) {
                dataIn = input.readLine();
                if (firstDataFlag) {
                    quiz = new Survey(dataIn);
                    firstDataFlag = false;
                    dataOut = "hello " + dataIn + "!";
                    dataOut += "\n\n" + quiz.getNextQuestion() + "\neol";
                    serverRespond.println(dataOut);
                } else {
                    if (quiz.endOfSurvey()) {
                        dataOut = quiz.checkAnswer(dataIn);
                        serverRespond.println((dataOut + "\nResult is: " + quiz.getScore()
                                + "\npress any key + enter to exit" + "\neol"));
                        SingletonWriter.getInstance().writeToAnswers(quiz.answersSummary());
                        SingletonWriter.getInstance().writeToResults(quiz.scoreSummary());

                        break;
                    }else {
                        dataOut = quiz.checkAnswer(dataIn);
                        serverRespond.println(dataOut + "\n" + quiz.getNextQuestion() + "\neol");
                    }
                }
            }
            serverRespond.println("end");
            serverSocket.close();
            System.out.println("end");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
