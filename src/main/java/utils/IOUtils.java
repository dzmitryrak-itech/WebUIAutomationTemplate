package utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ThreadLocalRandom;

public final class IOUtils {

    private static final int LEAST_PORT = 6000;

    public static Integer nextFreePort() {
        int port = (int)( Math.random() * 8000 ) + LEAST_PORT;
        while (true) {
            try ( ServerSocket endpoint = new ServerSocket(port) ) {
                System.out.println("Local Port on which this socket is listening: " + port);
                return port;
            } catch (IOException e) {
                port = ThreadLocalRandom.current().nextInt();
            }
        }
    }
}
