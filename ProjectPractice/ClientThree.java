import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientThree {
	public static void main(String[] args) {



		try {
			InetAddress inetAddress = InetAddress.getByName("10.200.233.99");
			int port = 12345;


				Socket socket = new Socket(inetAddress, port);
				System.out.println("Got Connected ...");
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				while (true) {
					String msg = in.readLine();
					try {
						movement(msg);
					} catch (NullPointerException nullPointerException){
						System.out.println("There is some error in msg");
						break;
					}

				}

		} catch (IOException e) {
			System.out.println("Retrying");
		}

	}



	private static void movement(String msg) throws  NullPointerException{

			String[] arr = msg.split(" ");
			int x = Integer.parseInt(arr[0]);
//		System.out.println(x);
			int y = Integer.parseInt(arr[1]);
//		System.out.println(y);

			cursorMove(x, y);

//		for (int i = 0; i < arr.length; i++){
//			System.out.println(arr[i]);
//		}

	}

	private static void cursorMove(int x, int y) {
		try {
			Robot robot = new Robot();

			robot.mouseMove(x, y);
		} catch (AWTException e) {
			throw new RuntimeException(e);
		}
	}
}