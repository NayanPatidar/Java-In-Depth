import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		InetAddress inetAddress = InetAddress.getByName("10.200.233.32");
		int port = 12345;

		Socket socket = new Socket(inetAddress, port);
		System.out.println("Got Connected ...");

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			String[] coordinates = line.split(" ");
			if (coordinates.length == 2) {
				int receivedX = Integer.parseInt(coordinates[0]);
				int receivedY = Integer.parseInt(coordinates[1]);

				cursorMove(receivedX, receivedY);
				try {
					Thread.sleep(7);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

				// You can use receivedX and receivedY to move your cursor or perform other actions
				System.out.println("Received Coordinates: " + receivedX + ", " + receivedY);
			}
		}

		// Close the socket when done
		socket.close();
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


//
//import java.awt.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.InetAddress;
//import java.net.Socket;
//
//public class Client {
//	public static void main(String[] args) throws IOException {
//		InetAddress inetAddress = InetAddress.getByName("10.200.233.32");
//		int port = 12345;
//
//		while (true) {
//			Socket socket = new Socket(inetAddress, port);
//			System.out.println("Got Connected ...");
//
//			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			System.out.println(reader);
//
//			String line;
//			while ((line = reader.readLine()) != null) {
//
//				String[] coordinates = line.split(" ");
//				if (coordinates.length == 2) {
//					int receivedX = Integer.parseInt(coordinates[0]);
//					int receivedY = Integer.parseInt(coordinates[1]);
//					System.out.println(receivedX + " " + receivedY);
//
//					cursorMove(receivedX, receivedY);
//					try {
//						Thread.sleep(7);
//					} catch (InterruptedException e) {
//						throw new RuntimeException(e);
//					}
//
//					// You can use receivedX and receivedY to move your cursor or perform other actions
//					System.out.println("Received Coordinates: " + receivedX + ", " + receivedY);
//				}
//			}
//		}
//	}
//
//	private static void cursorMove(int x, int y) {
//		try {
//			Robot robot = new Robot();
//			robot.mouseMove(x, y);
//		} catch (AWTException e) {
//			throw new RuntimeException(e);
//		}
//	}
//}
