import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Checkout extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton closeButton;
    private JPanel totalPricePanel;
    private JPanel pizzasPanel;

    public Checkout(Order order) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2);
        int y = (int) (dimension.getHeight()/2);
        this.setLocation(x-450,y-250);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        closeButton.addActionListener(new ActionListener() {
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

        pizzasPanel.setLayout(new GridLayout(order.getPizzaListSize()+1,1));
        totalPricePanel.setLayout(new GridLayout(order.getPizzaListSize()+1,1));
        for(int i = 0; i < order.getPizzaListSize(); i++){
            Pizza pizza = order.getPizzaList().get(i);
//            JLabel pizzaLabel = new JLabel(pizza.getPizzaText());
            JTextArea pizzaTA = new JTextArea(pizza.getPizzaText());
            pizzaTA.setEditable(false);
            String price = String.valueOf(order.getPizzaPrice(pizza));
            JTextArea priceLabel = new  JTextArea(String.valueOf(order.getPizzaPrice(pizza)));
            priceLabel.setEditable(false);
            pizzasPanel.add(pizzaTA);
            totalPricePanel.add(priceLabel);
        }
        JTextArea empty = new JTextArea("\t\t");
        empty.setEditable(false);
        pizzasPanel.add(empty);
        JTextArea priceLabel = new JTextArea("Total price: " + String.valueOf(order.getOrderPrice()));
        priceLabel.setEditable(false);
        totalPricePanel.add(priceLabel);

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
