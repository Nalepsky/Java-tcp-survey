package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread  {
    private Socket serverSocket;
    private String dataIn;
    private String dataOut;
    private Quiz quiz;
    private boolean firstDataFlag;

    public ServerThread(Socket serverSocket) {
        this.serverSocket = serverSocket;
        this.firstDataFlag = true;
    }

    public void run(){

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintStream serverRespond = new PrintStream(serverSocket.getOutputStream());

            while (!(dataIn = input.readLine()).equals("exit")){
                if(firstDataFlag){
                    quiz = new Quiz(dataIn);
                    firstDataFlag = false;
                    dataOut = "hello " + dataIn + "!";
                    dataOut +="\n\n" + quiz.getNextQuestion() + "\neol";
                    serverRespond.println(dataOut);
                }else{
                    dataOut = quiz.checkAnswer(dataIn);
                    serverRespond.println(dataOut + "\n" + quiz.getNextQuestion() + "\neol");
                    System.out.println(dataOut);
                }
            }

            serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
