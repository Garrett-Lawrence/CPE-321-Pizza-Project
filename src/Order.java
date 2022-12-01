import java.util.ArrayList;

public class Order {

    private ArrayList<Pizza> pizzaList;
    private double orderPrice;

    public Order(){
        pizzaList = new ArrayList<>() ;
    }

    public void addPizzaToOrder(Pizza newPizza){
        this.pizzaList.add(newPizza);
    }

    public int getPizzaCount() {
        return this.pizzaList.size();
    }

    public double getOrderPrice(){
        double sum = 0;
        for (int i = 0; i < this.pizzaList.size(); i++){
            sum += this.pizzaList.get(i).getPizzaPrice();
        }
        this.orderPrice = sum;
        return sum;
    }

}
