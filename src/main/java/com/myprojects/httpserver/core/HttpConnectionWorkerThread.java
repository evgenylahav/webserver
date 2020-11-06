package main.java.com.myprojects.httpserver.core;

import main.java.com.myprojects.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Evgeny Lahav
 */

public class HttpConnectionWorkerThread extends Thread{
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);
    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket){
        this.socket = socket;

    }


    @Override
    public void run() {
        LOGGER.info(" ** Connection accepted: " + socket.getInetAddress());
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            //String html =
            //    "<html><head><title>App Components</title></head><body><h1>Welcome to the app component page... </h1></body></html>";

            Path path = Paths.get("C:\\Users\\elahav109995\\IdeaProjects\\HTTPServer\\src\\main\\resources\\output.html");
            String html = Files.readString(path, StandardCharsets.US_ASCII);

            final String CRLF = "\n\r"; // 13, 10
            String response =
                "HTTP/1.1 200 OK" + CRLF +  // Status line : HTTP_VERSION RESPONSE_CODE RESPONSE_MESSAGE
                "Content-Length: " + html.getBytes().length + CRLF + // HEADER
                CRLF +
                html +
                CRLF + CRLF;

            outputStream.write(response.getBytes());

            LOGGER.info("Connection processing finished");
        } catch (IOException e) {

            LOGGER.error("Problem with communication", e);

        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {}
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {}
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {}
            }
        }

    }
}
