package BoundariesLess;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HideCursor {
    public void FrameCreation(boolean visibility, JFrame frame, Toolkit toolkit, String BreakOrNot) throws AWTException {
        Robot robot = new Robot();

        if (visibility) {
            Image blankImage = Toolkit.getDefaultToolkit().createImage(new byte[0]);
            Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(blankImage, new Point(0, 0), "blankCursor");

            frame.setCursor(blankCursor);
            frame.setOpacity(0.004f);
            frame.setVisible(true);



            robot.mouseMove(700, 300);
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } else if (!visibility) {
            frame.setVisible(false);

            frame.dispose();
        }


//        if (Objects.equals(BreakOrNot, "Break")) {
//
//            System.out.println("In Break");
//            frame.dispose();
//
//        } else if (Objects.equals(BreakOrNot, "Don'tBreak")) {
//            if (frame.isActive()){
//                System.out.println("Already Present");
//            } else if (!frame.isActive()) {
//                frame.dispose();
//                System.out.println("In Don't Break");
//                Dimension screenSize = toolkit.getScreenSize();
//
//                int screenWidth = screenSize.width;
//                int screenHeight = screenSize.height;
//                frame.setSize(screenWidth, screenHeight);
//
//                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//                Image blankImage = Toolkit.getDefaultToolkit().createImage(new byte[0]);
//                Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(blankImage, new Point(0, 0), "blankCursor");
//                frame.setCursor(blankCursor);
//                                frame.setUndecorated(true);
//                frame.setOpacity(0.004f);
//                frame.setVisible(visibility);
//            }

        }
        // Get the screen size

    }

