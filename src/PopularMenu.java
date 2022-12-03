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
    private JRadioButton RadioButton1;
    private JRadioButton RadioButton2;
    private JRadioButton RadioButton3;
    private JButton addAnotherButton;
    private JLabel pop1;
    private JLabel pop2;
    private JLabel pop3;
    private Order currentOrder;


    public PopularMenu(Order order) {
		this.currentOrder = order;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();          // constructor sets up GUI, buttons, and logic
        int x = (int) (dimension.getWidth()/2);
        int y = (int) (dimension.getHeight()/2);
        this.setLocation(x-450,y-250);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(checkoutButton);

        // Grouped all 9 buttons together so that only one can be clicked at a time
        ButtonGroup group = new ButtonGroup();
        group.add(RadioButton1); group.add(RadioButton2); group.add(RadioButton3);

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

        ArrayList<Pizza> popularPizzas = new ArrayList<>();
        popularPizzas = getPopularPizza();

        pop1.setText(popularPizzas.get(0).getPizzaText());
        pop2.setText(popularPizzas.get(1).getPizzaText());
        pop3.setText(popularPizzas.get(2).getPizzaText());

    }

    private void onCheckout() {
        boolean check = true;
        ArrayList<Pizza> popularPizzas = new ArrayList<>();
        popularPizzas = getPopularPizza();


        if (RadioButton1.isSelected()) {
            pizza = popularPizzas.get(0);
        }
        else if (RadioButton2.isSelected()) {
            pizza = popularPizzas.get(1);
        }
        else if (RadioButton3.isSelected()) {
            pizza = popularPizzas.get(2);
        }
        else {
            check = false;
            ErrorWindow errorWindow = new ErrorWindow();
            errorWindow.pack();
            errorWindow.setVisible(true);
        }
        if (check == true) {
            pizza.storeToXml();
            currentOrder.addPizzaToOrder(pizza);
            dispose();
            Checkout checkout = new Checkout(currentOrder);
            checkout.pack();
            checkout.setVisible(true);
        }
    }

    private void onAddAnother() {                   // adds another pizza
        boolean check = true;
        ArrayList<Pizza> popularPizzas = new ArrayList<>();
        popularPizzas = getPopularPizza();

        if (RadioButton1.isSelected()) {
            pizza = popularPizzas.get(0);
        }
        else if (RadioButton2.isSelected()) {
            pizza = popularPizzas.get(1);
        }
        else if (RadioButton3.isSelected()) {
            pizza = popularPizzas.get(2);
        }
        else {
            check = false;
            ErrorWindow errorWindow = new ErrorWindow();        // if the check turns out false, the error window is created and shown
            errorWindow.pack();
            errorWindow.setVisible(true);
        }
        if (check == true) {                                    // if check turns out false, close the current window and show second window
            pizza.storeToXml();
            currentOrder.addPizzaToOrder(pizza);
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

    public ArrayList<Pizza> getPopularPizza() {

        File folder = new File("src/pastPizzas");
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
        ArrayList<Pizza> popularPizzas = new ArrayList<>();
        for(int i=0; i<3; i++){
            popularPizzas.add(oldPizzas.get(i));
        }
        return popularPizzas;

    }

}
