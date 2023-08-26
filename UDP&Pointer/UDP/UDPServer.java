package UDP;

import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		InetAddress serverAddress = InetAddress.getByName("172.20.10.12");
		int serverPort = 12345;

		DatagramSocket socket = new DatagramSocket();

		while (true) {
			Point cursorLocation = MouseInfo.getPointerInfo().getLocation();
			int x = cursorLocation.x;
			int y = cursorLocation.y;

			String message = x + " " + y;
			byte[] sendData = message.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

			socket.send(sendPacket);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
