package ConcurrentThreadsOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickTracker {
	private JFrame jFrame;

			public MouseClickTracker(JFrame frame) {
				this.jFrame = frame;

				jFrame.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
							int x = e.getX();
							int y = e.getY();
							String clickInfo = "Mouse clicked at X: " + x + ", Y: " + y;
							if (e.getButton() == MouseEvent.BUTTON1) {
								clickInfo += " (Left button)";
							} else if (e.getButton() == MouseEvent.BUTTON2) {
								clickInfo += " (Middle button)";
							} else if (e.getButton() == MouseEvent.BUTTON3) {
								clickInfo += " (Right button)";
							}
							System.out.println(clickInfo);
					}
				});
			}
	}

