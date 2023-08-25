import javax.swing.*;
import java.awt.*;

public class CursorHiding {



	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Get the screen size
		Dimension screenSize = toolkit.getScreenSize();

		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
//		Thread.sleep(10000);
		frame.setSize(screenWidth, screenHeight);

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Image blankImage = Toolkit.getDefaultToolkit().createImage(new byte[0]);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(blankImage, new Point(0, 0), "blankCursor");
		frame.setCursor(blankCursor);
		frame.setUndecorated(true);
//		frame.getContentPane().setBackground(new Color(0, 0, 0, 0)); // R, G, B, Alpha
		frame.setOpacity(0.004f);
		frame.setVisible(true);

//	frame.setUndecorated(true);

		// Load a custom cursor image
//		ImageIcon cursorIcon = new ImageIcon("path_to_cursor_image.png");
//		Image cursorImage = cursorIcon.getImage();

		// Create a custom cursor using the loaded image
//		Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "customCursor");

		// Set the custom cursor for the frame
//		frame.setCursor(customCursor);
	}
}
