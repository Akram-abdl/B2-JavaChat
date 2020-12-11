package server;

import thread.ThreadClientHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ArrayList<ThreadClientHandler> m_clients = new ArrayList<>();
    private int clientNb = 0;
    public Server() {
        try {
            // Écoute réseau sur le port 1234
            ServerSocket ss = new ServerSocket(1234);

            Socket s;

            while(true) {
                System.out.println("Attente d'une connexion");

                s = ss.accept();

                System.out.println("Client "+ clientNb + " connecté");

                ThreadClientHandler ThreadClient = new ThreadClientHandler(s, "Client "+ clientNb, this);
                m_clients.add(ThreadClient);
                Thread t = new Thread(ThreadClient);
                t.start();
                clientNb++;
            }

        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        }
    }

    public ArrayList<ThreadClientHandler> getClients() {
        return m_clients;
    }

    public static void main(String[] args) {
        new Server();
    }

}
