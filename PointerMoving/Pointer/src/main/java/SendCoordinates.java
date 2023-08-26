import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendCoordinates {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("Accepting connection on 12345 .....");

		int x, y;


		while (true) {
			Socket waitForConnectionWithClient = serverSocket.accept(); // It will wait for the client to join
			System.out.println("Connection Accepted !!!");
			OutputStream outputStream = waitForConnectionWithClient.getOutputStream();


			while (true){
				x = (int)java.awt.MouseInfo.getPointerInfo().getLocation().getX();
				y = (int)java.awt.MouseInfo.getPointerInfo().getLocation().getY();
				System.out.println(x + " " + y + "\n");
				String msg = x + " " + y + "\n";

				outputStream.write(msg.getBytes());
				outputStream.flush();

			}
		}

	}
}
