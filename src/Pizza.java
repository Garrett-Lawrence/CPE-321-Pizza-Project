/**
 * Pizza contains toppings, crust, sizes, sauces
 * that can be added/removed for Customers order.
 */

 import java.beans.XMLEncoder;
 import java.beans.XMLDecoder;
 import java.io.*;

public class Pizza implements Serializable {


    private ToppingsList pizzaToppings;
    private Crust pizzaCrust;
    private Size pizzaSize;
    private Sauce pizzaSauce;


    /**
     * Constructor Pizza
     */
    public Pizza(){
    }
    // constructor with pizza inputs
    public Pizza(ToppingsList toppings, Crust crust, Sauce sauce, Size size){
        pizzaToppings = toppings;
        pizzaCrust = crust;
        pizzaSauce = sauce;
        pizzaSize = size;
    }

    // next couple of functions set the values of toppings, crust, size, and sauce for the pizza
    public void setPizzaToppings(ToppingsList pizzaToppings) {
        this.pizzaToppings = pizzaToppings;
    }

    public void setPizzaCrust(Crust pizzaCrust) {
        this.pizzaCrust = pizzaCrust;
    }

    public void setPizzaSize(Size pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public void setPizzaSauce(Sauce pizzaSauce) {
        this.pizzaSauce = pizzaSauce;
    }

    // next couple of functions get the values of toppings, crust, sauce, and size
    public ToppingsList getPizzaToppings() {
        return this.pizzaToppings;
    }

    public Crust getPizzaCrust() {
        return this.pizzaCrust;
    }

    public Sauce getPizzaSauce() {
        return this.pizzaSauce;
    }

    public Size getPizzaSize() { return this.pizzaSize; }

    // ability to changeItems within pizza
    public void changeItem(String itemType, String newItem, double price) {
        if (itemType == "Crust"){
            pizzaCrust = new Crust(newItem, price);
        } else if (itemType == "Sauce") {
            pizzaSauce = new Sauce(newItem, price);
        } else if (itemType == "Sauce") {
            pizzaSize = new Size(newItem);
        }
    }

    // function to add toppings
    public void addTopping(Topping topping){
        pizzaToppings.add(topping);
    }

    // function to remove toppings
    public void removeTopping(Topping topping){
        pizzaToppings.remove(topping);
    }

    // function that stores the pizza information to an xml file
    public void storeToXml(){
        String fileName = String.valueOf(System.currentTimeMillis()) +".xml";
        System.out.println(fileName);
        XMLEncoder encoder=null;
        try{
            File file = new File("src/pastPizzas/"+fileName);
            file.createNewFile();
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("ERROR: Initializing encoder");
        } catch (IOException e) {
            System.out.print("ERROR: Creating new File");
        }
        encoder.writeObject(this);
        encoder.close();
    }

    // function to convert the pizza info to a string and return the string
    public String getPizzaText(){
        String toppingsString = "";
        for(int i = 0; i < pizzaToppings.getToppingsList().size(); i++){
            toppingsString += ", " + pizzaToppings.getToppingsList().get(i).getToppingName();
        }

        return pizzaSize.getSize() + " " + pizzaCrust.getCrustName() + " crust pizza with " + pizzaSauce.getSauceName()
                + " sauce\n" + toppingsString;

    }

}
