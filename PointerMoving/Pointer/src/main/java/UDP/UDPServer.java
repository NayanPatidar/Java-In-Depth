package UDP;

import HideCursor.MainConfig;

import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class UDPServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress serverAddress = InetAddress.getByName("10.200.233.67");
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

			TimeUnit.MILLISECONDS.sleep(2);
		}
	}
}