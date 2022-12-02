/**
 * Second Window class opens up the second window display that asks the user to either order a popular pizza
 * or a custom pizza
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecondWindow extends JDialog {

    // creating panels and buttons
    private JPanel contentPane;
    private JButton buttonPopularMenu;
    private JButton buttonCustomMenu;

    // creating instance of Order for currentOrder
    private Order currentOrder;

    // constructor for SecondWindow that creates the window
    public SecondWindow(Order order) {
        this.currentOrder=order;
        // set up and sizing of window
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2);
        int y = (int) (dimension.getHeight()/2);
        this.setLocation(x-250,y-250);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonPopularMenu);

        // if popular button is pressed, then call onPopularMenu functiojn
        buttonPopularMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPopularMenu();
            }
        });

        // if custom menu button is pressed, then call onCustomMenu function
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

    // takes you to Popular Menu window
    private void onPopularMenu() {
        PopularMenu popularMenu = new PopularMenu(currentOrder);
        popularMenu.pack();
        popularMenu.setVisible(true);
        // closes out of Second window
        dispose();
    }

    // takes you to Custom Menu window
    private void onCustomMenu() {
        CustomMenu customMenu = new CustomMenu(currentOrder);
        customMenu.pack();
        customMenu.setVisible(true);
        // closes out of Second Window
        dispose();
    }

    // closes out of Second Window
    private void onCancel() {
        dispose();
    }
}
