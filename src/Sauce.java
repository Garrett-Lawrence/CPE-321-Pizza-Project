/**
 * Sauce contains type and price of each sauce option.
 */
public class Sauce {


    private String sauceName; // private variables that only class Sauce can use
    private double saucePrice;
    public Sauce(){ // constructor Sauce; initializes variables sauceName and saucePrice

    }

    public Sauce(String name, double price){ // constructor Sauce; initializes variables sauceName and saucePrice
        sauceName = name;
        saucePrice = price;
    }

    public double getSaucePrice(){
        return saucePrice;
    } // function to return saucePrice
    public String getSauceName() {
        return sauceName;
    }

    public void setSauceName(String sauceName) {
        this.sauceName = sauceName;
    }

    public void setSaucePrice(double saucePrice) {
        this.saucePrice = saucePrice;
    }
}
