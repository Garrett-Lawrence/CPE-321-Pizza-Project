
public class Size {
    private String size;
    private double sizePrice;

    public Size(String name){
        size = name;
        if (size == "Small")
            sizePrice = 10.00;
        else if (size == "Medium")
            sizePrice = 12.50;
        else if (size == "Large")
            sizePrice = 15.00;
    }

    public double getSizePrice(){
        return sizePrice;
    }
}
