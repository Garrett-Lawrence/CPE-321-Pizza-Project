import javax.swing.*;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PopularMenu {
    private JPanel panel1;
    private JScrollBar scrollBar1;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JRadioButton smallRadioButton1;
    private JRadioButton mediumRadioButton1;
    private JRadioButton largeRadioButton1;
    private JRadioButton smallRadioButton2;
    private JRadioButton mediumRadioButton2;
    private JRadioButton largeRadioButton2;
    public void getPopularToppings() {
        // loop through lines in the xml file
        // for i, then within for j,
        // have a count for either how many times the same topping appears
        // or how many times the same pizza (combo of toppings) appear
        // top 3 choices will be picked as most popular pizzas
        // somehow add these choices to the popular menu 1,2, and 3 Jpanels.
        // based on a condition in this function, display dialog boxes to the panels on the form
        File folder = new File("/pastPizzas");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Pizza> oldPizzas = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                XMLDecoder decoder=null;
                try {
                    decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
                } catch (FileNotFoundException e) {
                    System.out.println("ERROR: xml not found");
                }
               oldPizzas.add((Pizza) decoder.readObject());
            }
        }

        //TODO for loop here to parse through the list of objects oldPizzas and find popular toppings

    }
}

