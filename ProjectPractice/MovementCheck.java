import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import javax.tools.Tool;
import java.awt.*;

public class MovementCheck {
    public static void main(String[] args) throws InterruptedException {



        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension sizeOfScreen = toolkit.getScreenSize();

        int screenWidth = sizeOfScreen.width;
        int screenHeight = sizeOfScreen.height;
        System.out.println(screenHeight + " " + screenWidth + "\n");


        while (true){
            Point x = MouseInfo.getPointerInfo().getLocation();
        System.out.println(x.x + " " + x.y);

        Thread.sleep(80);
    }


//        while (true) {
//
//            Point cursorLocation = java.awt.MouseInfo.getPointerInfo().getLocation();
//            Rectangle screenBOunds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
//
//            boolean cursorWithinBounds = screenBOunds.contains(cursorLocation);
//
//            if (cursorWithinBounds) {
//                System.out.println("Yes");
//            } else if (!cursorWithinBounds) {
//                System.out.println("No");
//            }
//        }
    }
}
