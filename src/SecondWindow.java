import javax.swing.*;
import java.awt.event.*;

public class SecondWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonPopularMenu;
    private JButton buttonCustomMenu;

    public SecondWindow() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonPopularMenu);

        buttonPopularMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPopularMenu();
            }
        });

        buttonCustomMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCustomMenu();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onPopularMenu() {
        PopularMenu popularMenu = new PopularMenu();
        popularMenu.pack();
        popularMenu.setVisible(true);
        dispose();
    }

    private void onCustomMenu() {
        // add your code here if necessary
        dispose();
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
