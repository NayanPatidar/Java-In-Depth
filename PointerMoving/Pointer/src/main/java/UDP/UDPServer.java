package UDP;

import HideCursor.MainConfig;

import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		InetAddress serverAddress = InetAddress.getByName("10.200.233.131");
		int serverPort = 12345;

		DatagramSocket socket = new DatagramSocket();

		while (true) {
			Point cursorLocation = MouseInfo.getPointerInfo().getLocation();
			int x = cursorLocation.x;
			int y = cursorLocation.y;

//			if (x > 1279){
//				try {
//					MainConfig mainConfig = new MainConfig();
//
//
//				} catch (AWTException | InterruptedException e) {
//					throw new RuntimeException(e);
//				}
//
//			}

			String message = x + " " + y;
			byte[] sendData = message.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

			socket.send(sendPacket);

			try {
				Thread.sleep(11);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}