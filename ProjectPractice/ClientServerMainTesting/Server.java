package ClientServerMainTesting;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

		public static void main(String[] args) {
			int x, y;

			try {
				ServerSocket serverSocket = new ServerSocket(12345);

					Socket waitForConnectionWithClient = serverSocket.accept(); // It will wait for the client to join
					System.out.println("Connection Accepted !!!");

					try(
									OutputStream outputStream = waitForConnectionWithClient.getOutputStream();
									DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
					)
					{
					while (true){
						x = (int)java.awt.MouseInfo.getPointerInfo().getLocation().getX();
						y = (int)java.awt.MouseInfo.getPointerInfo().getLocation().getY();

						String msg = x + " " + y;
						dataOutputStream.writeUTF("X");
						dataOutputStream.writeInt(x);
						dataOutputStream.writeUTF("Y");
						dataOutputStream.writeInt(y);
						dataOutputStream.flush();

					}
					}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}


