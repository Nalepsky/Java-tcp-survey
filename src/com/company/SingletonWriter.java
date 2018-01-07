package com.company;

import java.io.*;

public class SingletonWriter {
    private static final SingletonWriter inst= new SingletonWriter();

    private SingletonWriter() {
        super();
    }

    public synchronized void writeToAnswers(String str) throws IOException {
        FileWriter fw = new FileWriter("Answers.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter saveToFile = new PrintWriter(bw);
        saveToFile.println(str);
        saveToFile.close();
    }

    public synchronized void writeToResults(String str) throws IOException {
        FileWriter fw = new FileWriter("Results.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter saveToFile = new PrintWriter(bw);
        saveToFile.println(str);
        saveToFile.close();
    }

    public static SingletonWriter getInstance() {
        return inst;
    }

}