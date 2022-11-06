/**
 * Sauce contains type and price of each sauce option.
 */
public class Sauce {
    private String sauceName;
    private double saucePrice;
    public Sauce(String name, double price){
        sauceName = name;
        saucePrice = price;
    }

    public double getSaucePrice(){
        return saucePrice;
    }
}
