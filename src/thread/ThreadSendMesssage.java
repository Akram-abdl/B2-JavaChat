package thread;

import java.io.PrintWriter;
import java.util.Scanner;

public class ThreadSendMesssage implements Runnable {
    private Scanner m_clavIn;
    private PrintWriter m_sockOut;

    public ThreadSendMesssage(Scanner clavIn, PrintWriter sockOut) {
        m_clavIn = clavIn;
        m_sockOut = sockOut;
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
