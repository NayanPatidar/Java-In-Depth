package ClientServerMainTesting;

import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTwo {
	public static void main(String[] args) throws InterruptedException, IOException {

		ServerSocket serverSocket = new ServerSocket(12345);
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Dimension sizeOfScreen = toolkit.getScreenSize();

		int screenWidth = sizeOfScreen.width;
		int screenHeight = sizeOfScreen.height;
		System.out.println(screenHeight + " " + screenWidth);

		Socket socket = serverSocket.accept();
		System.out.println("Connection Accepted !!");
		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

		while (true) {
			Point x = MouseInfo.getPointerInfo().getLocation();
			System.out.println(x.x + " " + x.y);

			dataOutputStream.writeInt(x.x);
			dataOutputStream.writeInt(x.y);
			dataOutputStream.flush();

			Thread.sleep(10);
		}
	}
}