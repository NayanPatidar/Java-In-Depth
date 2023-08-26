package UDP;

import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {
	public static void main(String[] args) throws IOException {

		try {
			Robot robot = new Robot();

			int serverPort = 12345;

			DatagramSocket socket = new DatagramSocket(serverPort);

			byte[] receiveData = new byte[1024];

			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);

				String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
				String[] coordinates = receivedMessage.split(" ");
				if (coordinates.length == 2) {
					int receivedX = Integer.parseInt(coordinates[0]);
					int receivedY = Integer.parseInt(coordinates[1]);
					movement(receivedX, receivedY, robot);
					Thread.sleep(8);
					// Process receivedX and receivedY as needed
//				System.out.println("Received Coordinates: " + receivedX + ", " + receivedY);
				}
			}
		} catch (AWTException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private static void movement(int receivedX, int receivedY, Robot robot) {
		robot.mouseMove(receivedX, receivedY);

	}
}
