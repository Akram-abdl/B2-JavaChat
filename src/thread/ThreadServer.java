package thread;

import server.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadServer implements Runnable{
    private Socket m_s;
    private Server m_parent;
    private String m_name;

    public ThreadServer(Socket s, Server server) {
        m_s = s;
        m_parent = server;
    }

    @Override
    public void run() {
        try {
            System.out.println("Un client est connecté");

            // Mécanisme de lecture ET d'écriture
            PrintWriter sock_out = new PrintWriter(m_s.getOutputStream(), true);
            BufferedReader sock_in = new BufferedReader(new InputStreamReader(m_s.getInputStream()));
            sock_out.println("Tu es co");
            sock_out.println("Pseudo : ");
            m_name = sock_in.readLine();
            m_parent.addUser(m_name);
            sock_out.println(String.format("Hey %s !", m_name));


            while (true) {
                // demande <- réception de la demande du client
                String demande = sock_in.readLine();
                System.out.println("demande");

                if (demande.equals("bye")) {
                    sock_out.println("byebye");
                    break;
                }
            }
            // Fermeture de la co
            m_s.close();
            System.out.println("Client déco");
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        }
    }
}
