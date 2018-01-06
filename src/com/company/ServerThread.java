package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread  {
    private Socket serverSocket;
    String respond;

    public ServerThread(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void run(){

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

            while (!(respond = input.readLine()).equals("exit")){
                respond += "hello ";

                PrintStream serverRespond = new PrintStream(serverSocket.getOutputStream());
                serverRespond.println(respond);
            }

            serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
