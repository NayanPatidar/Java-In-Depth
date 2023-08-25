package CursorUsage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MovingCursor {

	private int port = 8081;
	private int x,y;


	private ServerSocket SocketCreation(){
		try {
			ServerSocket socket = new ServerSocket(port);
			return socket;

		} catch (IOException e) {
			System.out.println("Got some error !!!");
		}
		return null;
	}


	// Makes connection with the Users
	// 1) Waits for the user to join it... till that time it keeps on trying it.
	// 2)
	private void makingConnection(ServerSocket socket) {

		try {
			
			// waitForTheConnection will keep trying to join the connection till it's done...
			Socket waitForTheConnection = socket.accept();
			System.out.println("Connection Accepted !!");
			PrintWriter printWriter = new PrintWriter(waitForTheConnection.getOutputStream());

			while (true){
				// Keep getting the location of cursor
				x = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getX();
				y = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getY();

				String msg = x + " " + y;
				printWriter.println(msg);
			}



		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		MovingCursor movingCursor = new MovingCursor();
		ServerSocket socket =	movingCursor.SocketCreation();
		movingCursor.makingConnection(socket);
	}


}
