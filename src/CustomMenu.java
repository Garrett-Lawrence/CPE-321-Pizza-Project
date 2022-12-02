import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * CustomMenu class that creates the interactive menu for creating your own pizza
 */
public class CustomMenu extends JDialog {
    // creating all the panels, buttons, and check boxes for different pizza choices
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

    // creating new instance of ToppingsList
    private ToppingsList toppingsList = new ToppingsList();

    // instances of crust, sauce, size, and Pizza
    private Crust crust;
    private Sauce sauce;
    private Size size;
    private Pizza customPizza;

    // constructor for actually creating the custom menu
    public CustomMenu() {
        // Set-up and sizing of window
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2);
        int y = (int) (dimension.getHeight()/2);
        this.setLocation(x-250,y-250);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCheckout);

        // Creating a button group so only one sauce is chosen
        ButtonGroup groupSauce = new ButtonGroup();
        groupSauce.add(originalSauceButton); groupSauce.add(oliveOilSauceButton);

        // Creating a crust group so only one crust is chosen
        ButtonGroup groupCrust = new ButtonGroup();
        groupCrust.add(originalCrustButton); groupCrust.add(stuffedCrustButton);
        groupCrust.add(garlicCrustButton);

        // Creating a size group so only one size is chosen
        ButtonGroup groupSize = new ButtonGroup();
        groupSize.add(smallRadioButton); groupSize.add(mediumRadioButton);
        groupSize.add(largeRadioButton);

        buttonCheckout.addActionListener(new ActionListener() {
            // if checkout button is pressed, call onCheckout function
            public void actionPerformed(ActionEvent e) {
                onCheckout();
            }
        });

        addAnotherButton.addActionListener(new ActionListener() {
            // if add another button is pressed, call onAddAnother function
            public void actionPerformed(ActionEvent e) {
                onAddAnother();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            // if cancel button is pressed, call onCancel function
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
        // creating new instances of each topping picked, then adding it to the toppingsList
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

        // ensuring that this if, else if, else structure are linked together
        if (true) {
            // depending on what size button is selected, create a new instance of Size
            if (smallRadioButton.isSelected()) {
                size = new Size("Small");
            } else if (mediumRadioButton.isSelected()) {
                size = new Size("Medium");
            } else if (largeRadioButton.isSelected()) {
                size = new Size("Large");
            } else {
                sizeCheck = false;
            }
        }
        if (true) {
            // depending on what crust button is selected, create a new instance of Crust

            if (originalCrustButton.isSelected()) {
                crust = new Crust("Original", 0.0);
            } else if (stuffedCrustButton.isSelected()) {
                crust = new Crust("Stuffed", 1.50);
            } else if (garlicCrustButton.isSelected()) {
                crust = new Crust("Garlic", 1.00);
            } else {
                crustCheck = false;
            }
        }
        if (true) {
            // depending on what sauce button is selected, create a new instance of Sauce

            if (originalSauceButton.isSelected()) {
                sauce = new Sauce("Original", 0.0);
            } else if (oliveOilSauceButton.isSelected()) {
                sauce = new Sauce("Olive Oil", 0.25);
            } else {
                sauceCheck = false;
            }
        }

        // if sauce and crust and size were selected
        if (sauceCheck == true && crustCheck == true && sizeCheck == true) {

            // create new pizza with the previously established attributes
            customPizza = new Pizza(toppingsList, crust, sauce, size);

            //close out of custom menu
            dispose();

            //open checkout menu
            Checkout checkout = new Checkout();
            checkout.pack();
            checkout.setVisible(true);
        }
        // if either no sauce, crust, or size is selected, then bring up error window
        else {
            ErrorWindow errorWindow = new ErrorWindow();
            errorWindow.pack();
            errorWindow.setVisible(true);
        }
    }

    private void onAddAnother() {
        boolean sizeCheck = true;
        boolean crustCheck = true;
        boolean sauceCheck = true;

        // creating new instances of each topping picked, then adding it to the toppingsList
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

        // depending on what size button is selected, create a new instance of Size
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
        }

        // depending on what crust button is selected, create a new instance of Crust
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
        }

        // depending on what sauce button is selected, create a new instance of Sauce
        if (originalSauceButton.isSelected()) {
            sauce = new Sauce("Original", 0.0);
        }
        else if (oliveOilSauceButton.isSelected()) {
            sauce = new Sauce("Olive Oil", 0.25);
        }
        else {
            sauceCheck =false;
        }

        // if sauce and crust and size were selected
        if (sauceCheck == true && crustCheck == true && sizeCheck == true) {

            // create new pizza with the previously established attributes
            customPizza = new Pizza(toppingsList, crust, sauce, size);

            // close window
            dispose();

            // open secondWindow
            SecondWindow secondWindow = new SecondWindow();
            secondWindow.pack();
            secondWindow.setVisible(true);
        }

        // if either no sauce, crust, or size is selected, then bring up error window
        else {
            ErrorWindow errorWindow = new ErrorWindow();
            errorWindow.pack();
            errorWindow.setVisible(true);
        }
    }

    private void onCancel() {
        // close custom window
        dispose();

        //opening second window
        SecondWindow secondWindow = new SecondWindow();
        secondWindow.pack();
        secondWindow.setVisible(true);
    }
}
