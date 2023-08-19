import java.io.*;
import java.net.*;

public class ClientTwo {
    public static void main(String[] args) throws IOException {
        InetAddress serverAddress = InetAddress.getByName("10.200.233.99"); // Replace with the server's IP
        int serverPort = 12345; // Same port number as on the server

        try (Socket socket = new Socket(serverAddress, serverPort);
             InputStream in = socket.getInputStream()){



            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);

            String receiveMessage = new String(buffer, 0, bytesRead);
            System.out.println("received message : " + receiveMessage);
        }
    }
}