package thread;

import java.io.PrintWriter;

public class ThreadSendMessageServer extends ThreadSendMesssage{
    public ThreadSendMessageServer(PrintWriter sockOut) {
        super(sockOut);
    }
}
