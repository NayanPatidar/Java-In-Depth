import java.awt.*;

public class CursorMovementExample {
    public int currentMovementInX(){
        int currentX = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getX();
        return currentX;
    }

    public int currentMovementInY(){
        int currentY = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getY();
        return currentY;
    }

    public static void main(String[] args) {

        CursorMovementExample obj = new CursorMovementExample();
        boolean moved = false;
        boolean ok = false;
        try {
            // Create a Robot instance
            Robot robot = new Robot();

            // Get the current cursor position
            while (!moved){
                int currentX = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getX();
                int currentY = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getY();

                while (!ok){
                if ((obj.currentMovementInX()-currentX != 0) || (obj.currentMovementInX()-currentX != 0) ||
                (obj.currentMovementInY()-currentY != 0) || (obj.currentMovementInY()-currentY != 0)){

                    System.out.println(obj.currentMovementInX());
                    System.out.println(obj.currentMovementInY());
                    // Move the cursor by a specified offset
                    int offsetX = -100;  // Example offset in the X direction
                        int offsetY = -50;   // Example offset in the Y direction
                    ok = true;
                    moved = true;

                    robot.mouseMove(currentX + offsetX, currentY + offsetY);
                }
                }
            }
            // Optionally, you can simulate a mouse click
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            e.  printStackTrace();
        }
    }
}