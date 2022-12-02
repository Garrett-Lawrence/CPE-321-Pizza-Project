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
    private JRadioButton originalCrustButton;
    private JRadioButton stuffedCrustButton;
    private JRadioButton garlicCrustButton;
    private JRadioButton originalSauceButton;
    private JRadioButton oliveOilSauceButton;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JButton addAnotherButton;
    private ToppingsList toppingsList;
    private Crust crust;
    private Sauce sauce;
    private Size size;
    private Pizza customPizza;

    public CustomMenu() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2);
        int y = (int) (dimension.getHeight()/2);
        this.setLocation(x-250,y-250);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCheckout);

        ButtonGroup groupSauce = new ButtonGroup();
        groupSauce.add(originalSauceButton); groupSauce.add(oliveOilSauceButton);

        ButtonGroup groupCrust = new ButtonGroup();
        groupCrust.add(originalCrustButton); groupCrust.add(stuffedCrustButton);
        groupCrust.add(garlicCrustButton);

        ButtonGroup groupSize = new ButtonGroup();
        groupSize.add(smallRadioButton); groupSize.add(mediumRadioButton);
        groupSize.add(largeRadioButton);

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
        boolean sizeCheck = false;
        boolean crustCheck = false;
        boolean sauceCheck = false;
        if (pepperoniCheckBox.isSelected()) {
            Topping pepperoni = new Topping("Pepperoni", 0.30);
            toppingsList.add(pepperoni);
        }
        if (sausageCheckBox.isSelected()) {
            Topping sausage = new Topping("Sausage", 0.40);
            toppingsList.add(sausage);
        }
        if (tomatoesCheckBox.isSelected()) {
            Topping tomato = new Topping("Tomatoes", 0.10);
            toppingsList.add(tomato);
        }
        if (peppersCheckBox.isSelected()) {
            Topping peppers = new Topping("Green Peppers", 0.20);
            toppingsList.add(peppers);
        }
        if (pineappleCheckBox.isSelected()) {
            Topping pineapple = new Topping("Pineapple", 0.30);
            toppingsList.add(pineapple);
        }
        if (mushroomCheckBox.isSelected()) {
            Topping mushroom = new Topping("Mushrooms", 0.30);
            toppingsList.add(mushroom);
        }
        if (olivesCheckBox.isSelected()) {
            Topping olives = new Topping("Olives", 0.15);
            toppingsList.add(olives);
        }
        if (onionsCheckBox.isSelected()) {
            Topping onions = new Topping("Onions", );
            toppingsList.add(onions);
        }
        if (extraCheeseCheckBox.isSelected()) {
            Topping cheese = new Topping("Cheese", );
            toppingsList.add(cheese);
        }

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
