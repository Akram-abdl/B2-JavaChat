package server;

import thread.ThreadServer;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ArrayList<String> m_users = new ArrayList<>();
    public Server() {
        try {
            // Écoute réseau sur le port 1234
            ServerSocket ss = new ServerSocket(1234);

            while(true) {
                System.out.println("Attente d'une connexion");

                Socket s = ss.accept();
                new Thread(new ThreadServer(s, this)).start();
            }

        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        }
    }

    public static void main(String[] args) {
        new Server();
    }

    public void addUser(String user)
    {
        m_users.add(user);
    }

}
