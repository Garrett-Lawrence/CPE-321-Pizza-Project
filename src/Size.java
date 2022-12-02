
public class Size {     // Size class to manage price according to chosen size
    private String size;
    private double sizePrice;

    public Size(String name){ // constructor to initialize size
        size = name;
        if (size == "Small")
            sizePrice = 10.00;
        else if (size == "Medium")
            sizePrice = 12.50;
        else if (size == "Large") // if else chain to assign a base price to pizza based on chosen size
            sizePrice = 15.00;
    }

    public double getSizePrice(){
        return sizePrice;
    } // function to return sizePrice
}
