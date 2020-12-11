package thread;

import java.io.PrintWriter;
import java.util.Scanner;

public class ThreadSendMesssage implements Runnable {
    protected PrintWriter m_sockOut;

    public ThreadSendMesssage(PrintWriter sockOut) {
        m_sockOut = sockOut;
    }

    @Override
    public void run() {

    }
}
