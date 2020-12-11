package thread;

import java.io.BufferedReader;

public class ThreadReadMessage implements Runnable{
    protected BufferedReader m_sockIn;

    public ThreadReadMessage(BufferedReader sockIn) {
        m_sockIn = sockIn;
    }

    @Override
    public void run() {
    }
}
