import javax.swing.*;
public class SecondWindow {
    public SecondWindow() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        JLabel label = new JLabel("You can order from our Popular Menu or Custom Pizza Menu!");
        JButton button1 = new JButton("Popular Menu");
        frame.getContentPane().add(button1);
        JButton button2 = new JButton("Custom Pizza Menu");
        frame.getContentPane().add(button2);
        frame.setVisible(true);
    }
}
