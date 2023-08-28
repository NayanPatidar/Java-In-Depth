package ConcurrentThreadsOne;

import javax.swing.*;
import java.awt.*;
import java.awt.font.ShapeGraphicAttribute;

public class GUI implements Runnable {
	private static JFrame jFrame;
	//	private int val = 1;
	private SharedData sharedData;

	public GUI( JFrame jFrame, SharedData sharedData) {
		GUI.jFrame = jFrame;
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		while (true) {
			Point mousePosition = MouseInfo.getPointerInfo().getLocation();

			if (mousePosition.getX() < 180 && (sharedData.getForGui() == 1)) {
				System.out.println("Leaving Screen");
				sharedData.setForGui(0);
				jFrame.setVisible(true);

			} else if (mousePosition.getX() >= 180 && (sharedData.getForGui() == 0)) {
				System.out.println("Entered Screen");
//				jFrame.setVisible(false);
				jFrame.dispose();
				sharedData.setForGui(1);

			}
		}
	}
}