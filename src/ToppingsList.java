import java.util.ArrayList;

/**
 * A collection of toppings for a pizza order.
 */
public class ToppingsList {


    private ArrayList<Topping> toppingsList;
    private double toppingsPrice;
    public ToppingsList(){
        toppingsList = new ArrayList<>() ;
    }   // constructor creates new arraylist for toppings

    public void remove(Topping topping){                           // void function that does not need to return anything; just removes the topping in desired index
        int index = toppingsList.indexOf(topping);
        toppingsList.remove(index);
    }

    public void add(Topping newTopping){
        toppingsList.add(newTopping);
    }  // function to add new topping to array list

    public int size(){
        return toppingsList.size();
    }                   // returns size of arraylist

    public double getToppingsPrice(){                                   // gets toppings price array list (toppingsList)
//        double sum = 0;
        for (int i = 0; i < toppingsList.size(); i++){
            toppingsPrice += toppingsList.get(i).getToppingPrice();           // for every index in the array list, sums up the topping price by getting the price of each topping
        }
//        toppingsPrice = sum;
        return toppingsPrice;                                                 // returns topping price in variable sum
    }
    public ArrayList<Topping> getToppingsList() {
        return toppingsList;
    }

    public void setToppingsList(ArrayList<Topping> toppingsList) {
        this.toppingsList = toppingsList;
    }

    public void setToppingsPrice(double toppingsPrice) {
        this.toppingsPrice = toppingsPrice;
    }
}
