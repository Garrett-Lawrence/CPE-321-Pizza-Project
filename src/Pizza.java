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
    public Pizza(ToppingsList toppings, Crust crust, Sauce sauce, Size size){
        pizzaToppings = toppings;
        pizzaCrust = crust;
        pizzaSauce = sauce;
        pizzaSize = size;
    }

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

    public String getPizzaText(){
        String toppingsString = "";
        for(int i = 0; i < pizzaToppings.getToppingsList().size(); i++){
            toppingsString += ", " + pizzaToppings.getToppingsList().get(i).getToppingName();
        }

        return pizzaSize.getSize() + " " + pizzaCrust.getCrustName() + " crust pizza with " + pizzaSauce.getSauceName()
                + " sauce\n" + toppingsString;


    }

}
