import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JButton jButton = new JButton("Click Me!");



        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.getContentPane().add(jButton);
        jFrame.setSize(250,250);
        jFrame.setVisible(true);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setVisible(true);

    }
}
