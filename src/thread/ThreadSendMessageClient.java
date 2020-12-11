package thread;

import java.io.PrintWriter;
import java.util.Scanner;

public class ThreadSendMessageClient extends ThreadSendMesssage{
    private Scanner m_clavIn = new Scanner(System.in);
    public ThreadSendMessageClient(PrintWriter sockOut) {
        super(sockOut);
    }
    @Override
    public void run() {
        while (true) {
            try {
                // read the message from the keyboard
                String msg = m_clavIn.nextLine();

                // Send message
                m_sockOut.println(msg);

                Thread.sleep(1000);
            } catch (Exception exc) {
                System.err.println(exc.getMessage());;
            }
        }
    }
}
