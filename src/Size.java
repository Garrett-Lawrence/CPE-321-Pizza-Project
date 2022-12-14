/**
 * Size class that stores possible sizes and allows you to getSizePrice
 */
public class Size {     // Size class to manage price according to chosen size


    private String size;
    private double sizePrice;

    public Size(){ // constructor to initialize size

    }

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
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSizePrice(double sizePrice) {
        this.sizePrice = sizePrice;
    }
}
