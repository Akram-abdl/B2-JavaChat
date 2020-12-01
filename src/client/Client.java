package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {


    public Client() {
        try {
            System.out.println("Connexion..");
            Socket s = new Socket("localhost",1234);
            BufferedReader sock_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter sock_out = new PrintWriter(s.getOutputStream(), true);
            Scanner clav_in = new Scanner(System.in);
            String message = sock_in.readLine();
            System.out.println(message);

            while (true){
                String demande = clav_in.next();
                sock_out.println(demande);
                String reponse = sock_in.readLine();
                System.out.println(reponse);

            }

        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }

    }
    public static void main(String[] args) {
        new Client();
    }
}
