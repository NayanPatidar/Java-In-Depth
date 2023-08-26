package ClientServerMainTesting;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTwo {
	public static void main(String[] args) throws IOException {
		InetAddress inetAddress = InetAddress.getByName("10.200.233.131");
		int port = 12345;

		while (true) {
			Socket socket = new Socket(inetAddress, port);
			System.out.println("Got Connected ...");

			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

			while (true) {
				int receivedX = dataInputStream.readInt();
				int receivedY = dataInputStream.readInt();

				cursorMove(receivedX, receivedY);

				// You can use receivedX and receivedY to move your cursor or perform other actions
				System.out.println("Received Coordinates: " + receivedX + ", " + receivedY);
			}
		}
	}


	private static void movement(String msg) throws  NullPointerException{

		String[] arr = msg.split(" ");
		int x = Integer.parseInt(arr[0]);
		System.out.println(x);
		int y = Integer.parseInt(arr[1]);
		System.out.println(y);

		cursorMove(x, y);

//		for (int i = 0; i < arr.length; i++){
//			System.out.println(arr[i]);
//		}

	}

	private static void cursorMove(int x, int y) {
		try {
			Robot robot = new Robot();

			robot.mouseMove(x, y);
		} catch (AWTException e) {
			throw new RuntimeException(e);
		}
	}
}
