package com.company;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        String inputData,
                respond,
                newLine;
        int port = 1410;
        Socket socket;
        Scanner scanner;

        try {
            scanner = new Scanner(System.in);
            socket = new Socket("127.0.0.1", port);
            Scanner serverScanner = new Scanner(socket.getInputStream());
            PrintStream serverPrint = new PrintStream(socket.getOutputStream());

            System.out.println("please, enter your name");

            while (true) {
                inputData = scanner.nextLine();

                serverPrint.println(inputData);
                respond = "";
                newLine = "";

                if(!serverScanner.hasNext()){
                    break;
                }

                while(!(newLine = serverScanner.nextLine()).equals("eol")){
                    respond += newLine + "\n";
                }
                System.out.println(respond);
            }
            scanner.close();
            socket.close();
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
