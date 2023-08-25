package ClientServerMainTesting;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		new Client().startClient();
	}

	private void startClient() {
		try {
			Robot robot = new Robot();
			InetAddress inetAddress = InetAddress.getByName("10.200.233.131");
			int port = 12345;

			Socket socket = new Socket(inetAddress, port);
			System.out.println("Got Connected ...");
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);

			int receivedX = -1;
			int receivedY = -1;

			while (true) {
				String msg = dataInputStream.readUTF();
				if (msg.equals("X")) {
					receivedX = dataInputStream.readInt();
				} else if (msg.equals("Y")) {
					receivedY = dataInputStream.readInt();
				}
//					movement(robot, receivedX, receivedY);
				System.out.println(receivedX+  " " + receivedY);
				}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (AWTException ex) {
			throw new RuntimeException(ex);
		}
	}

	private void movement(Robot robot, int receivedX, int receivedY) {
		robot.mouseMove(receivedX, receivedY);
	}
}





