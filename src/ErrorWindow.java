/**
 * ErrorWindow creates a window that displays an error when the user has no selection.
 * User clicks OK button and the error window closes, returning to previous window.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorWindow extends JDialog {
    // creating base plane
    private JPanel contentPane;

    // creating ok button
    private JButton buttonOK;

    public ErrorWindow() {
        // Setting up dimensions and sizing of pane
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2);
        int y = (int) (dimension.getHeight()/2);
        this.setLocation(x-450,y-250);
        setContentPane(contentPane);
        // setting modal to true
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            // when okay button is pressed, call onOK function which closes the window
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // closes window when okay is clicked
        dispose();
    }
}
