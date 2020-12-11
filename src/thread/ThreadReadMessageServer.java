package thread;

import java.io.BufferedReader;

public class ThreadReadMessageServer extends ThreadReadMessage{
    public ThreadReadMessageServer(BufferedReader sockIn) {
        super(sockIn);
    }
    @Override
    public void run() {
        while (true) {
            try {
                // read the message sent
                String msg = m_sockIn.readLine();
                if (msg.equals("bye")) {
                break;
                }

                Thread.sleep(1000);

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
    }
}
