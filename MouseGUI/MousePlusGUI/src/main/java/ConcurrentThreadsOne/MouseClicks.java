package ConcurrentThreadsOne;

import javax.swing.*;

public class MouseClicks implements Runnable{
	private JFrame jFrame;
	private SharedData sharedData;

	public MouseClicks(SharedData sharedData, JFrame jFrame) {
		this.jFrame = jFrame;
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sharedData.waitForFlag();

			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			if (sharedData.getFlag()) {
//				System.out.println("Mouse Clicking Enabled ... ");
				SwingUtilities.invokeLater(() -> {
					MouseClickTracker clickTracker = new MouseClickTracker(jFrame);
					clickTracker.setVisible(true);
				});

			}
		}
	}
}
