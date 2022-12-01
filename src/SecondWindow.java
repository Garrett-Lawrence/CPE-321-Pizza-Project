import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondWindow {
    private JButton popularMenuButton;
    private JButton customMenuButton;

    public SecondWindow() {
        popularMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PopularMenu popularMenu = new PopularMenu();
            }
        });
        customMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomMenu customMenu = new CustomMenu();
            }
        });
    }
}
