import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeTwo {
    public static void main(String[] args) {
        int x, y;

        try {
            ServerSocket serverSocket = new ServerSocket(12345);

            while (true) {
                Socket waitForConnectionWithClient = serverSocket.accept(); // It will wait for the client to join
                System.out.println("Connection Accepted !!!");
                PrintWriter printWriter = new PrintWriter(waitForConnectionWithClient.getOutputStream(), true);

                while (true){
                    x = (int)java.awt.MouseInfo.getPointerInfo().getLocation().getX();
                    y = (int)java.awt.MouseInfo.getPointerInfo().getLocation().getY();

                    String msg = x + " " + y;
                    printWriter.println(msg);
                    printWriter.flush();

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
