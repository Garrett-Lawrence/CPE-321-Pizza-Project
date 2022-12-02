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
    private ToppingsList toppingsList = new ToppingsList();
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
        boolean sizeCheck = true;
        boolean crustCheck = true;
        boolean sauceCheck = true;
        if (pepperoniCheckBox.isSelected()) {
            Topping pepperoni = new Topping("Pepperoni", 0.50);
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
            Topping onions = new Topping("Onions", 0.25);
            toppingsList.add(onions);
        }
        if (extraCheeseCheckBox.isSelected()) {
            Topping cheese = new Topping("Cheese", 0.40);
            toppingsList.add(cheese);
        }
        if (true) {
            if (smallRadioButton.isSelected()) {
                size = new Size("Small");
            } else if (mediumRadioButton.isSelected()) {
                size = new Size("Medium");
            } else if (largeRadioButton.isSelected()) {
                size = new Size("Large");
            } else {
                sizeCheck = false;
                ErrorWindow errorWindow = new ErrorWindow();
                errorWindow.pack();
                errorWindow.setVisible(true);
            }
        }
        if (true) {
            if (originalCrustButton.isSelected()) {
                crust = new Crust("Original", 0.0);
            } else if (stuffedCrustButton.isSelected()) {
                crust = new Crust("Stuffed", 1.50);
            } else if (garlicCrustButton.isSelected()) {
                crust = new Crust("Garlic", 1.00);
            } else {
                crustCheck = false;
                ErrorWindow errorWindow = new ErrorWindow();
                errorWindow.pack();
                errorWindow.setVisible(true);
            }
        }
        if (true) {
            if (originalSauceButton.isSelected()) {
                sauce = new Sauce("Original", 0.0);
            } else if (oliveOilSauceButton.isSelected()) {
                sauce = new Sauce("Olive Oil", 0.25);
            } else {
                sauceCheck = false;
                ErrorWindow errorWindow = new ErrorWindow();
                errorWindow.pack();
                errorWindow.setVisible(true);
            }
        }
        if (sauceCheck == true && crustCheck == true && sizeCheck == true) {
            customPizza = new Pizza(toppingsList, crust, sauce, size);
            dispose();
            Checkout checkout = new Checkout();
            checkout.pack();
            checkout.setVisible(true);
        }
    }

    private void onAddAnother() {
        boolean sizeCheck = true;
        boolean crustCheck = true;
        boolean sauceCheck = true;
        if (pepperoniCheckBox.isSelected()) {
            Topping pepperoni = new Topping("Pepperoni", 0.50);
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
            Topping onions = new Topping("Onions", 0.25);
            toppingsList.add(onions);
        }
        if (extraCheeseCheckBox.isSelected()) {
            Topping cheese = new Topping("Cheese", 0.40);
            toppingsList.add(cheese);
        }
        if (smallRadioButton.isSelected()) {
            size = new Size("Small");
        }
        else if (mediumRadioButton.isSelected()){
            size = new Size("Medium");
        }
        else if (largeRadioButton.isSelected()) {
            size = new Size("Large");
        }
        else {
            sizeCheck = false;
            ErrorWindow errorWindow = new ErrorWindow();
            errorWindow.pack();
            errorWindow.setVisible(true);
        }
        if (originalCrustButton.isSelected()) {
            crust = new Crust("Original", 0.0);
        }
        else if (stuffedCrustButton.isSelected()) {
            crust = new Crust("Stuffed", 1.50);
        }
        else if (garlicCrustButton.isSelected()) {
            crust = new Crust("Garlic", 1.00);
        }
        else {
            crustCheck = false;
            ErrorWindow errorWindow = new ErrorWindow();
            errorWindow.pack();
            errorWindow.setVisible(true);
        }
        if (originalSauceButton.isSelected()) {
            sauce = new Sauce("Original", 0.0);
        }
        else if (oliveOilSauceButton.isSelected()) {
            sauce = new Sauce("Olive Oil", 0.25);
        }
        else {
            sauceCheck =false;
            ErrorWindow errorWindow = new ErrorWindow();
            errorWindow.pack();
            errorWindow.setVisible(true);
        }
        if (sauceCheck == true && crustCheck == true && sizeCheck == true) {
            customPizza = new Pizza(toppingsList, crust, sauce, size);
            dispose();
            SecondWindow secondWindow = new SecondWindow();
            secondWindow.pack();
            secondWindow.setVisible(true);
        }
    }

    private void onCancel() {
        dispose();
        SecondWindow secondWindow = new SecondWindow();
        secondWindow.pack();
        secondWindow.setVisible(true);
    }
}
