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
    public Pizza(ToppingsList toppings, Crust crust, Sauce sauce, Size size){
        pizzaToppings = toppings;
        pizzaCrust = crust;
        pizzaSauce = sauce;
        pizzaSize = size;
    }

    public double getPizzaPrice(){
        pizzaPrice = this.pizzaToppings.getToppingsPrice() + this.pizzaCrust.getCrustPrice() +
                this.pizzaSauce.getSaucePrice() + this.pizzaSize.getSizePrice();
        return pizzaPrice;
    }

    public ToppingsList getPizzaToppings() {
        return this.pizzaToppings;
    }

    public Crust getPizzaCrust() {
        return this.pizzaCrust;
    }

    public Sauce getPizzaSauce() {
        return this.pizzaSauce;
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
