import java.util.ArrayList;

/**
 * A collection of toppings for a pizza order.
 */
public class ToppingsList {
    private ArrayList<Topping> toppingsList;
    private double toppingsPrice;
    public ToppingsList(){
        toppingsList = new ArrayList<>();
    }

    public void remove(Topping topping){
        int index = toppingsList.indexOf(topping);
        toppingsList.remove(index);
    }

    public void add(Topping newTopping){
        toppingsList.add(newTopping);
    }

    public int size(){
        return toppingsList.size();
    }

    public double getToppingsPrice(){
        double sum = 0;
        for (int i = 0; i < toppingsList.size(); i++){
            sum += toppingsList.get(i).getToppingPrice();
        }
        toppingsPrice = sum;
        return sum;
    }
}
