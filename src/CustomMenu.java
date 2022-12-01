import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomMenu extends JDialog {
    private JPanel contentPane;
    private JButton buttonCheckout;
    private JButton buttonCancel;
    private JCheckBox sausageCheckBox;
    private JCheckBox pepperoniCheckBox;
    private JCheckBox tomatoesCheckBox;
    private JCheckBox mushroomCheckBox;
    private JCheckBox pineappleCheckBox;
    private JCheckBox peppersCheckBox;
    private JCheckBox olivesCheckBox;
    private JCheckBox onionsCheckBox;
    private JCheckBox extraCheeseCheckBox;
    private JRadioButton originalRadioButton1;
    private JRadioButton stuffedRadioButton;
    private JRadioButton garlicRadioButton;
    private JRadioButton originalRadioButton;
    private JRadioButton oliveOilRadioButton;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JButton addAnotherButton;

    public CustomMenu() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2);
        int y = (int) (dimension.getHeight()/2);
        this.setLocation(x-250,y-250);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCheckout);

        buttonCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCheckout();
            }
        });

        addAnotherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAddAnother();
            }
        });

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

    private void onCheckout() {
        dispose();
        Checkout checkout = new Checkout();
        checkout.pack();
        checkout.setVisible(true);
    }

    private void onAddAnother() {
        dispose();
        SecondWindow secondWindow = new SecondWindow();
        secondWindow.pack();
        secondWindow.setVisible(true);
    }

    private void onCancel() {
        dispose();
        SecondWindow secondWindow = new SecondWindow();
        secondWindow.pack();
        secondWindow.setVisible(true);
    }
}
