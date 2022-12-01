import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow {
    private JButton startOrderButton;

    public FirstWindow() {
        startOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondWindow secondWindow = new SecondWindow();
            }
        });
    }
}
