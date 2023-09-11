package MsgRecieving;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

public class UDPClient {
	public UDPClient(){
		UDPMsg();
	}

	private static void movement(int receivedX, int receivedY, Robot robot) {
		robot.mouseMove(receivedX, receivedY);

	}

	public void UDPMsg(){
		try {
			Robot robot = new Robot();

			InetAddress inetAddress = InetAddress.getByName("10.200.233.99");
			int serverPortReceive = 12345;
			int serverPortSend = 12346;
			String msgToSend= "Stop";
			byte[] sendMsg = msgToSend.getBytes();

			DatagramSocket socketSend = new DatagramSocket(serverPortSend);
			DatagramSocket socketReceive = new DatagramSocket(serverPortReceive);


			DatagramPacket sendPacket = new DatagramPacket(sendMsg, sendMsg.length, inetAddress, 12346);
			byte[] receiveData = new byte[1024];

			while (true) {

				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socketReceive.receive(receivePacket);

				String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
				String[] coordinates = receivedMessage.split(" ");
				if (coordinates.length == 2) {
					int receivedX = Integer.parseInt(coordinates[0]);
					int receivedY = Integer.parseInt(coordinates[1]);
					movement(receivedX, receivedY, robot);
//					Thread.sleep(5);
					if (receivedX >= 1279){
						socketSend.send(sendPacket);
//						outputStream.write(sendMsg);
					}
				}
			}
		} catch (AWTException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
