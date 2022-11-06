import java.util.ArrayList;
/**
 * Pizza contains toppings, crust, sizes, sauces
 * that can be added/removed for Customers order.
 */
public class Pizza {
    private ToppingsList pizzaToppings;
    private Crust pizzaCrust;
    private Size pizzaSize;
    private Sauce pizzaSauce;
    private double pizzaPrice;
    /**
     * Constructor Pizza
     */
    public Pizza(ToppingsList toppings, Crust crust, Size size, Sauce sauce){
        pizzaToppings = toppings;
        pizzaCrust = crust;
        pizzaSauce = sauce;
        pizzaSize = size;
    }

    public double getPizzaPrice(){
        pizzaPrice = pizzaToppings.getToppingsPrice() + pizzaCrust.getCrustPrice() +
                pizzaSauce.getSaucePrice() + pizzaSize.getSizePrice();
        return pizzaPrice;
    }
}
