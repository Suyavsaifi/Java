import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args){
//        ArrayList newArray = new ArrayList();
        List newArray = new ArrayList();
//        Collection newArray = new ArrayList();
//        Iterator newArray = new ArrayList();

//        System.out.println("Content of array: " + newArray);
//        System.out.println("Is Emplty: " + newArray.isEmpty());


        newArray.add("EUR");
        newArray.add("USD");
        newArray.add("INR");
        newArray.add("JPY");
        newArray.add("GBP");
        newArray.add("AUD");

//        System.out.println("Content of array: " + newArray);
//        System.out.println("Is Emplty: " + newArray.isEmpty());
//        System.out.println("Length of array: " + newArray.size());

        newArray.add(12);
        newArray.add(23);
        newArray.add(true);

        System.out.println("Content of array: " + newArray);
//        System.out.println("Is Emplty: " + newArray.isEmpty());
//        System.out.println("Length of array: " + newArray.size());

        int result = (int) newArray.get(6) + (int) newArray.get(7);

        System.out.println("Result " + result);

        newArray.remove("EUR");

        System.out.println("Content of array: " + newArray);
        System.out.println("Is Emplty: " + newArray.isEmpty());
        System.out.println("Length of array: " + newArray.size());

        System.out.println("USD?: " + newArray.contains("USD"));

    }
}
