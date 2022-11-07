import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Menu {
    public Dictionary<String,String> toppingPrices;
    public Dictionary<String,String> crustPrices;
    public Dictionary<String,String> saucePrices;
    public final String[] sizeList = {"Small", "Medium", "Large"};

    public Menu(){
        toppingPrices = new Hashtable<>();
        crustPrices = new Hashtable<>();
        saucePrices = new Hashtable<>();
    }

    public void addToppingToMenu(String key, String value){
        toppingPrices.put(key,value);
    }

    public void removeToppingFromMenu(String key){
        toppingPrices.remove(key);
    }

    public void addCrustToMenu(String key, String value){
        crustPrices.put(key,value);
    }

    public void removeCrustFromMenu(String key){
        crustPrices.remove(key);
    }

    public void addSauceToMenu(String key, String value){
        saucePrices.put(key,value);
    }

    public void removeSauceFromMenu(String key){
        saucePrices.remove(key);
    }

    public double returnToppingPrice(String key){
        String value = toppingPrices.get(key);
        return Double.parseDouble(value);
    }

    public double returnCrustPrice(String key){
        String value = crustPrices.get(key);
        return Double.parseDouble(value);
    }

    public double returnSaucePrice(String key){
        String value = saucePrices.get(key);
        return Double.parseDouble(value);
    }
}
