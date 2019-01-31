package utils;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ThreadLocalRandom;

@Log4j2
public final class IOUtils {

    private static final int LEAST_PORT = 6000;

    public static Integer nextFreePort() {
        int port = (int)( Math.random() * 8000 ) + LEAST_PORT;
        while (true) {
            try ( ServerSocket endpoint = new ServerSocket(port) ) {
                log.debug(String.format("Local Port on which this socket is listening: %s", port));
                return port;
            } catch (IOException e) {
                port = ThreadLocalRandom.current().nextInt();
            }
        }
    }
}
