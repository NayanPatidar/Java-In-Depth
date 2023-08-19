import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientOne {
    public static void main(String[] args) throws IOException {

        byte[] buffer;
        int bytesRead ;


        InetAddress serverAddress = InetAddress.getByName("10.200.233.99"); // Replace with the server's IP
        int serverPort = 12345; // Same port number as on the server

        try (Socket socket = new Socket(serverAddress, serverPort);
             InputStream in = socket.getInputStream()){



            buffer = new byte[1024];
            bytesRead = in.read(buffer);

        }


        String receiveMessage = new String(buffer, 0, bytesRead);
        String[] arr = receiveMessage.split(" ");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);


        System.out.println("received message : " + receiveMessage);
        try {
            move(x,y);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }

    private static void move(int x, int y) throws AWTException {
        System.out.println("herter");
        Robot robot = new Robot();
        robot.mouseMove(x, y);
    }
}