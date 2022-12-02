/**
 * Topping contains name and price of each topping
 */
public class Topping {


    private String toppingName;
    private double toppingPrice;

    // constructor to set the value of toppingName and toppingPrice

    public Topping(){

    }
    public Topping(String name, double price){
        toppingName = name;
        toppingPrice = price;
    }

    // function that returns the price of topping
    public double getToppingPrice(){
        return toppingPrice;
    }
    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }
}
