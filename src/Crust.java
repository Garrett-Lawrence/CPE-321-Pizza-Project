/**
 * Crust contains type and price of each crust option.
 */
public class Crust {


    // Crust Class
    private String crustName;
    private double crustPrice;

    public Crust() {                // Constructor that initializes the crustName and crustPrice variables

    }
    public Crust(String name, double price) {                // Constructor that initializes the crustName and crustPrice variables
        crustName = name;                                   // Takes input string Name and price double
        crustPrice = price;
    }

    public double getCrustPrice() {
        return crustPrice;
    }    // Function to return crust price

    public String getCrustName() {
        return crustName;
    }

    public void setCrustName(String crustName) {
        this.crustName = crustName;
    }

    public void setCrustPrice(double crustPrice) {
        this.crustPrice = crustPrice;
    }
}