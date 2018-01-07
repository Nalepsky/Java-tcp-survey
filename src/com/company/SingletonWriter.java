package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SingletonWriter {
    private static final SingletonWriter inst= new SingletonWriter();

    private SingletonWriter() {
        super();
    }

    public synchronized void writeToAnswers(String str) throws FileNotFoundException {
        PrintWriter saveToFile = new PrintWriter("Answers.txt");
        saveToFile.println(str);
    }

    public synchronized void writeToResults(String str) throws FileNotFoundException {
        PrintWriter saveToFile = new PrintWriter("Results.txt");
        saveToFile.println(str);
    }

    public static SingletonWriter getInstance() {
        return inst;
    }

}