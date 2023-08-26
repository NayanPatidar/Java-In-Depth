package CursorThings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class MainConfig {

	public static void main(String[] args) throws InterruptedException, AWTException {

//        CursorThings.MainConfig mainConfig = new CursorThings.MainConfig();

		final Robot robot = new Robot();
		final HideCursor hideCursor = new HideCursor();
		final JFrame jFrame = new JFrame();
		final Toolkit toolkit = Toolkit.getDefaultToolkit();

		Dimension screenSize = toolkit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		jFrame.setSize(screenWidth, screenHeight);
		jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jFrame.setUndecorated(true);


		Timer motion = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				while (true) {
					Point mousePosition = MouseInfo.getPointerInfo().getLocation();
					if (mousePosition.x < 1) {
						// Mouse is leaving the screen
						System.out.println("Leaving Screen");
						try {
							hideCursor.FrameCreation(true, jFrame, toolkit, "Break");
							robot.mouseMove(mousePosition.x, mousePosition.y);
						} catch (AWTException ex) {
							throw new RuntimeException(ex);
						}
//                        robot.mouseMove();
//                        try {
////                            Thread.sleep(100000);
//                        } catch (InterruptedException ex) {
//                            throw new RuntimeException(ex);
//                        }
					} else {
						// Mouse is on the screen
						System.out.println("On the Screen");
						try {
							hideCursor.FrameCreation(false, jFrame, toolkit, "Don'tBreak");
						} catch (AWTException ex) {
							throw new RuntimeException(ex);
						}

					}
				}
			}
		});

		motion.start();
		TimeUnit.MINUTES.sleep(5);

//        while (true) {
//            Point x = MouseInfo.getPointerInfo().getLocation();
//            System.out.println(x.x);
//            if (x.x < 1) {
//                System.out.println("Leaving Screen");
//                hideCursor.FrameCreation(true, jFrame, toolkit, "Don'tBreak");
//
//            } else if (x.x >= 1) {
//                System.out.println("Entering Screen");
//                hideCursor.FrameCreation(false, jFrame, toolkit, "Break");
//            }
//        }
//        HideCursor hideCursor = new HideCursor(true);
	}
}