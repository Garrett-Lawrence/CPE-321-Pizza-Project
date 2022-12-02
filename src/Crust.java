/**
 * Crust contains type and price of each crust option.
 */
public class Crust {
    // Crust Class
    private String crustName;
    private double crustPrice;
    public Crust(String name, double price){
        crustName = name;
        crustPrice = price;
    }

    public double getCrustPrice(){
        return crustPrice;
    }
}
