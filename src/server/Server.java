package server;

import thread.ThreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() {
        try {
            // Écoute réseau sur le port 1234
            ServerSocket ss = new ServerSocket(1234);

            while(true) {
                System.out.println("Attente d'une connexion");

                Socket s = ss.accept();
                new Thread(new ThreadServer(s));
            }

        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        }
    }

}
