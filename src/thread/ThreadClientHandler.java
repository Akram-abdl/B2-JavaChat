package thread;

import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClientHandler implements Runnable{
    final Socket m_s;
    final Server m_parent;
    final String m_name;
    final PrintWriter m_sockOut;
    final BufferedReader m_sockIn;
    private Boolean isLogged;

    public ThreadClientHandler(Socket s, String name, Server parent) throws IOException {
        this.m_s = s;
        this.m_name = name;
        this.m_parent = parent;
        this.m_sockIn = new BufferedReader(new InputStreamReader(s.getInputStream()));;
        this.m_sockOut = new PrintWriter(s.getOutputStream(), true);;
        this.isLogged=true;
    }

    @Override
    public void run() {
        String msg;
        while(true) {
            try {
                msg = m_sockIn.readLine();

                System.out.println(msg);
                if (msg.equals("bye")) {
                    this.isLogged = false;
                    this.m_s.close();
                    break;
                }
                for (ThreadClientHandler client : m_parent.getClients())
                {
                    if (client.isLogged && client != this){
                        client.m_sockOut.println(this.m_name + " : "+ msg);
                    }
                }


            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        System.out.println("Client déconnecté");
    }
}
