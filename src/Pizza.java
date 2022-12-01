/**
 * Pizza contains toppings, crust, sizes, sauces
 * that can be added/removed for Customers order.
 */

 import java.beans.XMLEncoder;
 import java.beans.XMLDecoder;
 import java.io.BufferedOutputStream;
 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;

public class Pizza {
    private ToppingsList pizzaToppings;
    private Crust pizzaCrust;
    private Size pizzaSize;
    private Sauce pizzaSauce;
    private double pizzaPrice;
    /**
     * Constructor Pizza
     */
    public Pizza(ToppingsList toppings, Crust crust, Size size, Sauce sauce){
        pizzaToppings = toppings;
        pizzaCrust = crust;
        pizzaSauce = sauce;
        pizzaSize = size;
    }

    public double getPizzaPrice(){
        pizzaPrice = pizzaToppings.getToppingsPrice() + pizzaCrust.getCrustPrice() +
                pizzaSauce.getSaucePrice() + pizzaSize.getSizePrice();
        return pizzaPrice;
    }

    public void changeItem(String itemType, String newItem, double price) {
        if (itemType == "Crust"){
            pizzaCrust = new Crust(newItem, price);
        } else if (itemType == "Sauce") {
            pizzaSauce = new Sauce(newItem, price);
        } else if (itemType == "Sauce") {
            pizzaSize = new Size(newItem);
        }
    }

    public void addTopping(Topping topping){
        pizzaToppings.add(topping);
    }

    public void removeTopping(Topping topping){
        pizzaToppings.remove(topping);
    }

    public void storeToXml(String fileName){
        XMLEncoder encoder=null;
        try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("ERROR: While Creating or Opening the File");
        }
        encoder.writeObject(this);
        encoder.close();
    }

}
