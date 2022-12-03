/**
 * Welcome Window class opens up the welcome window display that allows user to Start Order of Cancel
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    // Constructor for creating welcome window
    public WelcomeWindow() {
        // Set up and sizing of window
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2);
        int y = (int) (dimension.getHeight()/2);
        this.setLocation(x-450,y-250);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        // if ok button is clicked, call onStartOrder function
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onStartOrder();
            }
        });

        // if cancel button is clicked, call onCancel function
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
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

    // onStartOrder creates a new order from the Order class, opens up the second window, and closes WelcomeWindow
    private void onStartOrder() {
        Order order  = new Order();
        SecondWindow secondWindow = new SecondWindow(order);
        secondWindow.pack();
        secondWindow.setVisible(true);
        dispose();
    }

    // onCancel closes WelcomeWindow
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    // Main function that opens up the first Window of the program, Welcome Window
    public static void main(String[] args) {
        WelcomeWindow dialog = new WelcomeWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
