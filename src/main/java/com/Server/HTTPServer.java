package com.Server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class HTTPServer {
    public HTTPServer() throws IOException, InterruptedException {
        System.out.println("Loading the web server...");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new Handler());
        server.createContext("/process_input", new FormSubmissionHandler());
        server.setExecutor(null);
        server.start();

        TimeUnit.SECONDS.sleep(60);


    }
}
