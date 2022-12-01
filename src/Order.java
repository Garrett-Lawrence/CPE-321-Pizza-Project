import java.util.ArrayList;

public class Order {

    private ArrayList<Pizza> pizzaList;
    private double orderPrice;

    public Order(){
        pizzaList = new ArrayList<>() ;
    }

    public void addPizzaToOrder(Pizza newPizza){
        pizzaList.add(newPizza);
    }

    public double getOrderPrice(){
        double sum = 0;
        for (int i = 0; i < pizzaList.size(); i++){
            sum += pizzaList.get(i).getPizzaPrice();
        }
        orderPrice = sum;
        return sum;
    }

}
