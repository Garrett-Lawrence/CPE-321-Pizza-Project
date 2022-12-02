/**
 * Order class stores the list of pizzas in the current order and the orderPrice
 */
import java.util.ArrayList;
public class Order {

    // array to hold list of pizzas in order
    private ArrayList<Pizza> pizzaList;
    // total order price
    private double orderPrice;

    // constructors for Order that just creates new empty pizzaList
    public Order(){
        pizzaList = new ArrayList<>() ;
    }

    // add Pizza to the pizzaList
    public void addPizzaToOrder(Pizza newPizza){
        this.pizzaList.add(newPizza);
    }

    // returning the size of pizzaList for number of pizzas
    public int getPizzaCount() {
        return this.pizzaList.size();
    }

    // function that returns total price of order
    public double getOrderPrice(){
        double sum = 0;
        // loops through each item in pizza list and adds together the prices
        for (int i = 0; i < this.pizzaList.size(); i++){
//            sum += this.pizzaList.get(i).getPizzaPrice();
            sum += getPizzaPrice(this.pizzaList.get(i));
        }
        this.orderPrice = sum;
        return sum;
    }
    public double getPizzaPrice(Pizza pizza){
        double pizzaPrice = pizza.getPizzaToppings().getToppingsPrice() + pizza.getPizzaCrust().getCrustPrice()+ pizza.getPizzaSauce().getSaucePrice() + pizza.getPizzaSize().getSizePrice();
        System.out.println(pizzaPrice);
        return pizzaPrice;
    }
}
