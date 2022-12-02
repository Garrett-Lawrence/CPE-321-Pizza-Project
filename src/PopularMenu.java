/**
 * Popular Menu Window class opens up the popular window display that allows user to pick a popular pizza to order
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class PopularMenu extends JDialog {              // popular menu inherits JDialog functionality
    private Pizza popularPizza1;
    private Pizza popularPizza2;
    private Pizza popularPizza3;
    private Pizza pizza;
    private JPanel contentPane;
    private JButton checkoutButton;
    private JButton buttonCancel;
    private JRadioButton smallRadioButton;
    private JRadioButton largeRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton smallRadioButton1;
    private JRadioButton largeRadioButton1;
    private JRadioButton mediumRadioButton1;
    private JRadioButton smallRadioButton2;
    private JRadioButton largeRadioButton2;
    private JRadioButton mediumRadioButton2;
    private JButton addAnotherButton;
    private Order currentOrder;


    public PopularMenu(Order order) {
		this.currentOrder = order;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();          // constructor sets up GUI, buttons, and logic
        int x = (int) (dimension.getWidth()/2);
        int y = (int) (dimension.getHeight()/2);
        this.setLocation(x-250,y-250);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(checkoutButton);

        // Grouped all 9 buttons together so that only one can be clicked at a time
        ButtonGroup group = new ButtonGroup();
        group.add(smallRadioButton); group.add(mediumRadioButton); group.add(largeRadioButton);
        group.add(smallRadioButton1); group.add(mediumRadioButton1); group.add(largeRadioButton1);
        group.add(smallRadioButton2); group.add(mediumRadioButton2); group.add(largeRadioButton2);

        //set for popular pizzas

        checkoutButton.addActionListener(new ActionListener() {
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
        boolean check = true;
        if (smallRadioButton.isSelected()) {
            //pizza = new Pizza(popularPizza1.getPizzaToppings(), popularPizza1.getPizzaCrust(),
            //popularPizza1.getPizzaSauce(), new Size("Small"));
        }
        else if (smallRadioButton1.isSelected()) {
            pizza = new Pizza(popularPizza2.getPizzaToppings(), popularPizza2.getPizzaCrust(),
                    popularPizza2.getPizzaSauce(), new Size("Small"));
        }
        else if (smallRadioButton2.isSelected()) {
            pizza = new Pizza(popularPizza3.getPizzaToppings(), popularPizza3.getPizzaCrust(),
                    popularPizza3.getPizzaSauce(), new Size("Small"));
        }
        else if (mediumRadioButton.isSelected()) {
            pizza = new Pizza(popularPizza1.getPizzaToppings(), popularPizza1.getPizzaCrust(),
                    popularPizza1.getPizzaSauce(), new Size("Medium"));
        }
        else if (mediumRadioButton1.isSelected()) {
            pizza = new Pizza(popularPizza2.getPizzaToppings(), popularPizza2.getPizzaCrust(),
                    popularPizza2.getPizzaSauce(), new Size("Medium"));
        }
        else if (mediumRadioButton2.isSelected()) {
            pizza = new Pizza(popularPizza3.getPizzaToppings(), popularPizza3.getPizzaCrust(),
                    popularPizza3.getPizzaSauce(), new Size("Medium"));
        }
        else if (largeRadioButton.isSelected()) {
            pizza = new Pizza(popularPizza1.getPizzaToppings(), popularPizza1.getPizzaCrust(),
                    popularPizza1.getPizzaSauce(), new Size("Large"));
        }
        else if (largeRadioButton1.isSelected()) {
            pizza = new Pizza(popularPizza2.getPizzaToppings(), popularPizza2.getPizzaCrust(),
                    popularPizza2.getPizzaSauce(), new Size("Large"));
        }
        else if (largeRadioButton2.isSelected()) {
            pizza = new Pizza(popularPizza3.getPizzaToppings(), popularPizza3.getPizzaCrust(),
                    popularPizza3.getPizzaSauce(), new Size("Large"));
        }
        else {
            check = false;
            ErrorWindow errorWindow = new ErrorWindow();
            errorWindow.pack();
            errorWindow.setVisible(true);
        }
        if (check == true) {
            dispose();
            Checkout checkout = new Checkout();
            checkout.pack();
            checkout.setVisible(true);
        }
    }

    private void onAddAnother() {                   // adds another pizza
        boolean check = true;
        if (smallRadioButton.isSelected()) {
            //pizza = new Pizza(popularPizza1.getPizzaToppings(), popularPizza1.getPizzaCrust(),
            //popularPizza1.getPizzaSauce(), new Size("Small"));
        }
        else if (smallRadioButton1.isSelected()) {
            pizza = new Pizza(popularPizza2.getPizzaToppings(), popularPizza2.getPizzaCrust(),
                    popularPizza2.getPizzaSauce(), new Size("Small"));
        }
        else if (smallRadioButton2.isSelected()) {
            pizza = new Pizza(popularPizza3.getPizzaToppings(), popularPizza3.getPizzaCrust(),
                    popularPizza3.getPizzaSauce(), new Size("Small"));
        }
        else if (mediumRadioButton.isSelected()) {
            pizza = new Pizza(popularPizza1.getPizzaToppings(), popularPizza1.getPizzaCrust(),
                    popularPizza1.getPizzaSauce(), new Size("Medium"));
        }
        else if (mediumRadioButton1.isSelected()) {
            pizza = new Pizza(popularPizza2.getPizzaToppings(), popularPizza2.getPizzaCrust(),
                    popularPizza2.getPizzaSauce(), new Size("Medium"));
        }
        else if (mediumRadioButton2.isSelected()) {
            pizza = new Pizza(popularPizza3.getPizzaToppings(), popularPizza3.getPizzaCrust(),
                    popularPizza3.getPizzaSauce(), new Size("Medium"));
        }
        else if (largeRadioButton.isSelected()) {
            pizza = new Pizza(popularPizza1.getPizzaToppings(), popularPizza1.getPizzaCrust(),
                    popularPizza1.getPizzaSauce(), new Size("Large"));
        }
        else if (largeRadioButton1.isSelected()) {
            pizza = new Pizza(popularPizza2.getPizzaToppings(), popularPizza2.getPizzaCrust(),
                    popularPizza2.getPizzaSauce(), new Size("Large"));
        }
        else if (largeRadioButton2.isSelected()) {
            pizza = new Pizza(popularPizza3.getPizzaToppings(), popularPizza3.getPizzaCrust(),
                    popularPizza3.getPizzaSauce(), new Size("Large"));
        }
        else {
            check = false;
            ErrorWindow errorWindow = new ErrorWindow();        // if the check turns out false, the error window is created and shown
            errorWindow.pack();
            errorWindow.setVisible(true);
        }
        if (check == true) {                                    // if check turns out false, close the current window and show second window
            dispose();
            SecondWindow secondWindow = new SecondWindow(currentOrder);
            secondWindow.pack();
            secondWindow.setVisible(true);
        }
    }

    private void onCancel() {                               // if cancel box checked, dispose current window and open second window
        dispose();
        SecondWindow secondWindow = new SecondWindow(currentOrder);
        secondWindow.pack();
        secondWindow.setVisible(true);
    }

    public void getPopularToppings() {

        File folder = new File("/pastPizzas");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Pizza> oldPizzas = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                XMLDecoder decoder=null;
                try {
                    decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
                } catch (FileNotFoundException e) {
                    System.out.println("ERROR: xml not found");
                }
                oldPizzas.add((Pizza) decoder.readObject());
            }
        }

        //TODO for loop here to parse through the list of objects oldPizzas and find popular toppings

    }

}
