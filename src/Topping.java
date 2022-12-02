/**
 * Topping contains name and price of each topping
 */
public class Topping {
    private String toppingName;
    private double toppingPrice;

    // constructor to set the value of toppingName and toppingPrice
    public Topping(String name, double price){
        toppingName = name;
        toppingPrice = price;
    }

    // function that returns the price of topping
    public double getToppingPrice(){
        return toppingPrice;
    }
}
