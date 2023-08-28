package ConcurrentThreadsOne;

import javax.swing.*;
import java.awt.*;

public class Starting {

	static JFrame jFrame = new JFrame();
	public Starting(){
		try {
			final Robot robot = new Robot();
		} catch (AWTException e) {
			throw new RuntimeException(e);
		}

		final Toolkit toolkit = Toolkit.getDefaultToolkit();

		Dimension screenSize = toolkit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		jFrame.setSize(screenWidth, screenHeight);
		jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jFrame.setUndecorated(true);
		jFrame.setOpacity(0.05f);
		jFrame.setAlwaysOnTop(true);
		creatingThreads(jFrame);
	}

	public void creatingThreads(JFrame jFrame){

		SharedData sharedData = new SharedData();

		Thread threadA = new Thread(new GUI(jFrame, sharedData));
		Thread threadB = new Thread(new MouseClicks(jFrame , sharedData) );

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