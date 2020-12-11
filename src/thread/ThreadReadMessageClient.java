package thread;

import java.io.BufferedReader;
import java.io.IOException;

public class ThreadReadMessageClient extends ThreadReadMessage{
    public ThreadReadMessageClient(BufferedReader sockIn) {
        super(sockIn);
    }
    @Override
    public void run() {
        while (true) {
            try {
                // read the message sent to this client
                String msg = m_sockIn.readLine();
                System.out.println(msg);
            } catch (Exception exc) {
                System.err.println(exc.getMessage());;
            }
        }
    }
}
