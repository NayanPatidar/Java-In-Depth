package MsgRecieving;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Testing {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("10.200.233.99", 12345);
		InputStream inputStream = socket.getInputStream();
		OutputStream outputStream = socket.getOutputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String serverMsg = reader.readLine();
		System.out.println(serverMsg);

		if (Objects.equals(serverMsg, "Starting")){
			String msg = "Sure";
			outputStream.write(msg.getBytes());
			System.out.println("Sent");
			socket.close();
			new UDPClient();
		}
	}
}
