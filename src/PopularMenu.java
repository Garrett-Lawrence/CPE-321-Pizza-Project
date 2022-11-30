import javax.swing.*;
public class PopularMenu {
    public PopularMenu(){
        JFrame frame = new JFrame("Charger Pizza");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        JLabel label = new JLabel("Welcome to Charger Pizza!");
        JButton button = new JButton("Cancel");
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
