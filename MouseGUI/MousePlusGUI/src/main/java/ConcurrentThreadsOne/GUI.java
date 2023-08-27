package ConcurrentThreadsOne;

import javax.swing.*;
import java.awt.*;

public class GUI implements Runnable {
	private JFrame jFrame;
	private SharedData sharedData;

	public GUI(SharedData sharedData, JFrame jFrame) {
		this.jFrame = jFrame;
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		while (true) {
			Point mousePosition = MouseInfo.getPointerInfo().getLocation();
			if (mousePosition.getX() < 80) {
//				System.out.println("Leaving Screen");

				jFrame.setVisible(true);
				sharedData.setFlag();
			} else if (mousePosition.getY() >= 80) {
//				System.out.println("Entered Screen");
				jFrame.setVisible(false);
				sharedData.removeFlag();
			}
		}
	}
}
