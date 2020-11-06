package main.java.com.myprojects.httpserver;

import main.java.com.myprojects.httpserver.config.Configuration;
import main.java.com.myprojects.httpserver.config.ConfigurationManager;
import main.java.com.myprojects.httpserver.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Evgeny Lahav
 *
 * Driver class for the http server
 */

public class HttpServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {
        LOGGER.info("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");

        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        LOGGER.info("Using port: " + conf.getPort());
        LOGGER.info("Using webRoot: " + conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}
