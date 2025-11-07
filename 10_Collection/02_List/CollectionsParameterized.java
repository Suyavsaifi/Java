import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionsParameterized {
    public static void main(String[] args){
//        List<String> currency = new ArrayList();
//        List<String> anotherCurrency = new ArrayList();
//
//        // adding data to list;
//        currency.add("EUR");
//        currency.add("INR");
//        currency.add("USD");
//
//        System.out.println("Content: " + currency);
//        System.out.println("Size of list: " + currency.size());
//
//        anotherCurrency.add("AUD");
//        anotherCurrency.add("GBP");
//
//        // adding content of anotherCurrecny to currency List
//
//        currency.addAll(anotherCurrency);
//
//        System.out.println("Content: " + currency);
//        System.out.println("Size of list: " + currency.size());

        List<String> cities = new ArrayList();
        List<String> cities2 = new ArrayList();

        cities2.add("Mumbai");
        cities2.add("Dubai");
        cities2.add("Riyad");

        cities.add("New York");
        cities.add("London");
        cities.add("Palo Alto");
        cities.add("Mumbai");
        cities.add("Dubai");

        cities.add("Seattle");  // will be added at the last of the list
        cities.add(1, "Seattle");  // will be added at the 1st index position

        System.out.println("Content: " + cities);

        cities.remove(0);

        System.out.println("Content: " + cities);

        // checking the index of value
        System.out.println("Index of Seattle: " + cities.indexOf("Seattle"));
        System.out.println("Index of Seattle: " + cities.lastIndexOf("Seattle"));

        // checking if cities2 values are in the cities list.
        System.out.println("Content of cities2 are there in cities? " + cities.containsAll(cities2));

    }
}
