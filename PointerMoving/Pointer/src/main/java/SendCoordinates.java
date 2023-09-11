import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SendCoordinates {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("Accepting connection on 12345 .....");

		int x, y;



			Socket waitForConnectionWithClient = serverSocket.accept(); // It will wait for the client to join
			System.out.println("Connection Accepted !!!");
			OutputStream outputStream = waitForConnectionWithClient.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

			while (true){
				Point cursorLocation = MouseInfo.getPointerInfo().getLocation();
				x = cursorLocation.x;
				y = cursorLocation.y;
				String msg = x + " " + y + "\n";
				outputStream.write(msg.getBytes());
		}

	}
}
