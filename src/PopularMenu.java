import javax.swing.*;
import java.awt.event.*;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class PopularMenu extends JDialog {
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

    public PopularMenu() {
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

    private void onAddAnother() {
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

    public void getPopularToppings() {
        // loop through lines in the xml file for i, then within for j, have a count for either how many times the same
        // topping appears or how many times the same pizza (combo of toppings) appears top 3 choices will be picked
        // as most popular pizzas somehow add these choices to the popular menu 1,2, and 3 Jpanels.
        // based on a condition in this function, display dialog boxes to the panels on the form
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
