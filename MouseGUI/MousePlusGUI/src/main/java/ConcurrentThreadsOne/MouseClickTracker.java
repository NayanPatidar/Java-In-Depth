package ConcurrentThreadsOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickTracker extends JFrame {

	private JLabel infoLabel;

	public MouseClickTracker(JFrame frame) {
		setTitle("Mouse Click Tracker");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		infoLabel = new JLabel("No mouse clicks yet.");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(infoLabel, BorderLayout.CENTER);

		frame.addMouseListener(new MouseAdapter() {
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
				infoLabel.setText(clickInfo);
			}
		});
	}

	// Rest of the class remains the same
}
