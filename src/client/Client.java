package client;

import thread.ThreadReadMessage;
import thread.ThreadReadMessageClient;
import thread.ThreadSendMessageClient;
import thread.ThreadSendMesssage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public Client() {
        try {
            System.out.println("Connexion..");
            Socket s = new Socket("localhost",1234);
            BufferedReader sock_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter sock_out = new PrintWriter(s.getOutputStream(), true);
            Thread send = new Thread(new ThreadSendMessageClient(sock_out));
            Thread read = new Thread(new ThreadReadMessageClient(sock_in));
            read.start();
            send.start();

        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }

    }
    public static void main(String[] args) {
        new Client();
    }
}
