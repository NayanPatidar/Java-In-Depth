package ConcurrentThreadsOne;

import javax.swing.*;
import java.awt.*;

public class Starting {

	public Starting(){
		try {
			final Robot robot = new Robot();
		} catch (AWTException e) {
			throw new RuntimeException(e);
		}
		final JFrame jFrame = new JFrame();
		final Toolkit toolkit = Toolkit.getDefaultToolkit();

		Dimension screenSize = toolkit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		jFrame.setSize(screenWidth, screenHeight);
		jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jFrame.setUndecorated(true);
		jFrame.setOpacity(0.5f);
		jFrame.setAlwaysOnTop(true);
		creatingThreads(jFrame);
	}

	public void creatingThreads(JFrame jFrame){

		SharedData sharedData = new SharedData();

		Thread threadA = new Thread(new GUI(sharedData, jFrame));
		Thread threadB = new Thread(new MouseClicks(sharedData, jFrame));

		threadA.start();
		threadB.start();

		try {
			threadA.join();
			threadB.join();
			System.out.println("Here");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
