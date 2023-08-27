package ConcurrentThreadsOne;

import ConcurrentThreadsOne.MouseClickTracker;
import ConcurrentThreadsOne.SharedData;

import javax.swing.*;

public class MouseClicks implements Runnable {
	private JFrame jFrame;
	private SharedData sharedData;
	private MouseClickTracker clickTracker;
	volatile boolean methodCalled = false;

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
				if (clickTracker == null) {
					SwingUtilities.invokeLater(() -> {
						clickTracker = new MouseClickTracker(jFrame);
						methodCalled = true;
					});
				}
			} else {
				if (clickTracker != null) {
					SwingUtilities.invokeLater(() -> {
						jFrame.dispose();
						methodCalled = false;
					});
				}
			}
		}
	}
}
