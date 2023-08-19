import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Choose a port number

        System.out.println("Server listening on port 12345...");

        Socket clientSocket = serverSocket.accept(); // Wait for a client to connect
        System.out.println("Client connected: " + clientSocket.getInetAddress());

//        try (InputStream in = clientSocket.getInputStream()) {
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//
//            while ((bytesRead = in.read(buffer)) != -1) {
//                System.out.println("Received: " + new String(buffer, 0, bytesRead));
//            }
//        }

        try (OutputStream outputStream = clientSocket.getOutputStream()) {
            int x = 155;
            int y = 600;
            String msg = x + " " + y;
            outputStream.write(msg.getBytes());
        }

        clientSocket.close();
        serverSocket.close();
    }
}

