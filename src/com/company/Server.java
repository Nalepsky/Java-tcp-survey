package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String args[]) throws IOException{
        String respond;

        ServerSocket serverSocket = new ServerSocket(1410);
        Socket socket = serverSocket.accept();

        Scanner scanner = new Scanner(socket.getInputStream());
        respond = "hello " +  scanner.nextLine();

        PrintStream serverRespond = new PrintStream(socket.getOutputStream());
        serverRespond.println(respond);
    }
}
