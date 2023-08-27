package MouseClicks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickTracker extends JFrame {

	private JLabel infoLabel;

	public MouseClickTracker() {
		setTitle("Mouse Click Tracker");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setSize(dimension.width, dimension.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		infoLabel = new JLabel("No mouse clicks yet.");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(infoLabel, BorderLayout.CENTER);

		addMouseListener(new MouseAdapter() {
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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MouseClickTracker clickTracker = new MouseClickTracker();
			clickTracker.setVisible(true);
		});
	}
}
