package com.company;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        String name,
                respond;
        int port = 1410;
        Socket socket;
        Scanner nameScanner;

        try {
            nameScanner = new Scanner(System.in);
            socket = new Socket("127.0.0.1", port);
            Scanner serverScanner = new Scanner(socket.getInputStream());

            System.out.println("please, enter your name");
            name = nameScanner.nextLine();

            PrintStream serverPrint = new PrintStream(socket.getOutputStream());
            serverPrint.println(name);
            respond = serverScanner.nextLine();

            System.out.println(respond);

            nameScanner.close();
            socket.close();
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
