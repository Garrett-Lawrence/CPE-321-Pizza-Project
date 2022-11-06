
public class Size {
    private String size;
    private double sizePrice;

    public Size(String name){
        size = name;
        if (size == "small")
            sizePrice = 10.00;
        else if (size == "medium")
            sizePrice = 12.50;
        else if (size == "large")
            sizePrice = 15.00;
    }

    public double getSizePrice(){
        return sizePrice;
    }
}
