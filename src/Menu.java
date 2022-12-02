import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Menu contains hash tables about topping, crust, and sauce prices. It also includes the corresponding functions.
 */
public class Menu {
    public Dictionary<String,String> toppingPrices;
    public Dictionary<String,String> crustPrices;
    public Dictionary<String,String> saucePrices;                   // Initializing dictionaries to store key value pairs for topping, crust, and sauce prices.
    public final String[] sizeList = {"Small", "Medium", "Large"};  // 3 different types of pizza sizes

    public Menu(){                                                  // Constructor to initialize hash tables
        toppingPrices = new Hashtable<>();
        crustPrices = new Hashtable<>();
        saucePrices = new Hashtable<>();
    }

    public void addToppingToMenu(String key, String value){
        toppingPrices.put(key,value);
    } // function to add toppings and prices

    public void removeToppingFromMenu(String key){
        toppingPrices.remove(key);
    } // function to remove the topping

    public void addCrustToMenu(String key, String value){
        crustPrices.put(key,value);
    } // function to add crust and prices to menu

    public void removeCrustFromMenu(String key){
        crustPrices.remove(key);
    }

    public void addSauceToMenu(String key, String value){
        saucePrices.put(key,value);
    }

    public void removeSauceFromMenu(String key){
        saucePrices.remove(key);
    }

    public double returnToppingPrice(String key){                          // function that gets thr topping price then returns it as double
        String value = toppingPrices.get(key);
        return Double.parseDouble(value);
    }

    public double returnCrustPrice(String key){                           // function that gets the crust price then returns it as double
        String value = crustPrices.get(key);
        return Double.parseDouble(value);
    }

    public double returnSaucePrice(String key){                           // function that gets the sauce price then returns it as double
        String value = saucePrices.get(key);
        return Double.parseDouble(value);
    }
}
