package ConcurrentThreadsOne;

import javax.swing.*;
public class MouseClicks implements Runnable {
	private JFrame jFrame;
	MouseClickTracker clickTracker;
	public int val = 0;
	private final SharedData sharedData;

	public MouseClicks(JFrame jFrame, SharedData sharedData) {
		this.jFrame = jFrame;
		this.sharedData = sharedData;
	}


	@Override
	public void run() {
		while (true) {
			if ((sharedData.getForMouseClicks() == 0) && (val == 0)){
				System.out.println("Calling GUI");
				SwingUtilities.invokeLater(() -> {
					clickTracker = new MouseClickTracker(jFrame);
				});
				val ++;
			}else if ((sharedData.getForMouseClicks() == 1) && (val == 1)){
				System.out.println("Disposing GUI");
				if (clickTracker != null) {
					clickTracker.disposeMouseListener();
				}
				jFrame.dispose();
				val--;
			}

		}
	}
}