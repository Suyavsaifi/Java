import java.io.*;
import java.util.*;

/**
 * - Demonstrates Sets (HashSet, LinkedHashSet, TreeSet)
 * - Demonstrates TreeSet with Integer ordering and null note
 * - Demonstrates String compareTo outputs
 * - Demonstrates SortedSet utilities (first, last, headSet, tailSet, subSet)
 * - Demonstrates custom Product with Comparable and using Comparator
 * - Demonstrates TreeSet with custom (descending) Comparator for Strings
 *
 * Single-file: Product is implemented as a static nested class so you can compile/run this one file.
 */
public class Main {

    public static void main(String[] args) {

        // 1) Sets: HashSet, LinkedHashSet, TreeSet (strings)
        System.out.println("=== 1) Sets ordering demo ===");
        String[] carsArray = new String[] { "Volvo", "BMW", "Honda", "Audi", "Mercedes" };

        Set<String> hashSet = new HashSet<>(Arrays.asList(carsArray));
        Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(carsArray));
        Set<String> treeSet = new TreeSet<>(Arrays.asList(carsArray));

        System.out.println("Order of car names in a HashSet (random order)");
        for (String name : hashSet) System.out.println(name);

        System.out.println("\nOrder of car names in a LinkedHashSet (insertion order)");
        for (String name : linkedHashSet) System.out.println(name);

        System.out.println("\nOrder of car names in a TreeSet (natural order)");
        for (String name : treeSet) System.out.println(name);


        // 2) TreeSet of Integers (natural order) and note about null
        System.out.println("\n=== 2) TreeSet with Integers (natural order) ===");
        Integer[] integersArray = new Integer[] { 3300, 400, 100, 700, 900, 600 };
        Set<Integer> intTree = new TreeSet<>(Arrays.asList(integersArray));
        for (Integer i : intTree) System.out.println(i);
        System.out.println("Note: adding null to a TreeSet will cause NullPointerException (not allowed here).");


        // 3) compareTo examples for Strings
        System.out.println("\n=== 3) String compareTo examples ===");
        System.out.println("A compareTo B: " + ("A".compareTo("B")));
        System.out.println("A compareTo Z: " + ("A".compareTo("Z")));
        System.out.println("B compareTo A: " + ("B".compareTo("A")));
        System.out.println("Z compareTo A: " + ("Z".compareTo("A")));
        System.out.println("L compareTo L: " + ("L".compareTo("L")));
        System.out.println("X compareTo X: " + ("X".compareTo("X")));
        System.out.println("A compareTo a: " + ("A".compareTo("a")));
        System.out.println("b compareTo B: " + ("b".compareTo("B")));


        // 4) SortedSet / TreeSet operations (first, last, headSet, tailSet, subSet)
        System.out.println("\n=== 4) SortedSet (vowels) demo ===");
        SortedSet<String> vowelSet = new TreeSet<>();
        vowelSet.add("A"); vowelSet.add("E"); vowelSet.add("I"); vowelSet.add("O"); vowelSet.add("U");
        System.out.println("Vowels are: " + vowelSet);
        System.out.println("First vowel: " + vowelSet.first());
        System.out.println("Last vowel: " + vowelSet.last());
        System.out.println("Vowels which come before I: " + vowelSet.headSet("I"));
        System.out.println("Vowels which come after I (includes I): " + vowelSet.tailSet("I"));
        System.out.println("Vowels which come between E and U (includes E): " + vowelSet.subSet("E", "U"));


        // 5) Product example: Comparable and Comparator usage with TreeSet
        System.out.println("\n=== 5) Product in TreeSet (Comparable or Comparator) ===");
        // First: Product implements Comparable (by name then category) — demonstrate TreeSet natural ordering
        SortedSet<Product> productSetComparable = new TreeSet<>();
        productSetComparable.add(new Product("iPhone", "Mobiles"));
        productSetComparable.add(new Product("Samsung", "Electronics"));
        productSetComparable.add(new Product("Levis", "Apparel"));
        productSetComparable.add(new Product("Rolex", "Accessories"));

        System.out.println("-- Product TreeSet using Comparable (name then category) --");
        for (Product p : productSetComparable) System.out.println(p);

        // Second: TreeSet with explicit Comparator (same ordering but demonstrated as example)
        System.out.println("\n-- Product TreeSet using explicit Comparator (name then category) --");
        Comparator<Product> productComparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                int compareName = o1.getName().compareTo(o2.getName());
                if (compareName != 0) return compareName;
                return o1.getCategory().compareTo(o2.getCategory());
            }
        };
        SortedSet<Product> productSetWithComparator = new TreeSet<>(productComparator);
        productSetWithComparator.addAll(productSetComparable);
        for (Product p : productSetWithComparator) System.out.println(p);


        // 6) TreeSet with custom Comparator for Strings (descending)
        System.out.println("\n=== 6) TreeSet with descending string Comparator ===");
        Comparator<String> descendingOrderComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { return o2.compareTo(o1); }
        };
        SortedSet<String> descTree = new TreeSet<>(descendingOrderComparator);
        descTree.addAll(Arrays.asList(carsArray));
        for (String name : descTree) System.out.println(name);


        System.out.println("\n=== End of consolidated demo ===");
    }
}
