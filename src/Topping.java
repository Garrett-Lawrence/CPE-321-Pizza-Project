/**
 * Topping contains name and price of each topping
 */
public class Topping {
    private String toppingName;
    private double toppingPrice;
    public Topping(String name, double price){
        toppingName = name;
        toppingPrice = price;
    }

    public double getToppingPrice(){
        return toppingPrice;
    }
}
