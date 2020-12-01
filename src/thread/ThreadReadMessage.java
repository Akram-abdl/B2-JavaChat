package thread;

import java.io.BufferedReader;

public class ThreadReadMessage implements Runnable{
    private BufferedReader m_sockIn;

    public ThreadReadMessage(BufferedReader sockIn) {
        m_sockIn = sockIn;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // read the message sent
                String msg = m_sockIn.readLine();
                System.out.println(msg);
                if (msg.equals("byebye")) break;

                Thread.sleep(1000);

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        System.out.println("SLAUR");
        Thread.currentThread().interrupt();
    }
}
