import java.util.*;

public class Main {

    public static void main(String[] args) {
        demonstrateHashMapBasics();
        System.out.println();
        demonstrateNullsAndViews();
        System.out.println();
        demonstrateLinkedHashMaps();
        System.out.println();
        demonstrateTreeMapVariants();
        System.out.println();
        demonstrateTreeMapNavigation();
        System.out.println();
        demonstrateCustomObjectsInMaps();
        System.out.println();
        demonstrateLRUCache();
    }

    private static void demonstrateHashMapBasics() {
        Map<Integer, String> actors = new HashMap<>();
        System.out.println("Actors map empty? : " + actors.isEmpty());
        System.out.println("Actors map size : " + actors.size());

        actors.put(1001, "Tom Hanks");
        actors.put(1002, "Will Smith");
        actors.put(1003, "Bruce Willis");
        System.out.println("\nActors: " + actors);

        System.out.println("\n***** Adding elements");
        actors.put(1004, "Chris Evans");
        actors.put(1005, "Brad Pitt");
        System.out.println("Actors: " + actors);

        System.out.println("\n***** Retrieving elements");
        System.out.format("Key: %s, Value: %s%n", 1003, actors.get(1003));
        System.out.format("Key: %s, Value: %s%n", 1008, actors.get(1008)); // null

        System.out.println("\n***** Deleting elements");
        System.out.println("Actors (original): " + actors);
        actors.remove(1001);
        actors.remove(1003);
        System.out.println("Actors: " + actors);

        System.out.println("\n***** Updating elements");
        actors.put(1001, "Aamir Khan");
        actors.put(1005, "Amitabh Bachchan");
        System.out.println("Actors: " + actors);
    }

    private static void demonstrateNullsAndViews() {
        Map<Integer, String> movies = new HashMap<>();
        System.out.println("**** Any number of nulls allowed in values");
        movies.put(1202, "Titanic");
        movies.put(1203, null);
        movies.put(1501, "Back to the Future");
        movies.put(1884, "The Godfather");
        movies.put(2932, "Casablanca");
        movies.put(6929, null);

        for (Map.Entry<Integer, String> e : movies.entrySet()) {
            System.out.format("Key: %s, Value: %s%n", e.getKey(), e.getValue());
        }

        System.out.println("\n**** The key can be null as well (only one null key allowed)");
        movies.put(null, "Jaws");
        movies.put(null, "The Godfather II");
        System.out.println("Map (with null key updated): " + movies);

        System.out.println("\n***** Map views: entrySet, keySet, values");
        System.out.println("entrySet: " + movies.entrySet());
        System.out.println("keySet: " + movies.keySet());
        System.out.println("values: " + movies.values());
    }

    private static void demonstrateLinkedHashMaps() {
        Map<Integer, String> insertionOrder = new LinkedHashMap<>();
        insertionOrder.put(1784, "The Godfather");
        insertionOrder.put(1202, "Titanic");
        insertionOrder.put(1503, "Jaws");
        insertionOrder.put(1501, "Saving Private Ryan");

        System.out.println("****** LinkedHashMap insertion order");
        insertionOrder.forEach((k, v) -> System.out.println(k + " -> " + v));

        Map<Integer, String> accessOrder = new LinkedHashMap<>(16, 0.75f, true);
        accessOrder.putAll(insertionOrder);

        System.out.println("\nAccess-order LinkedHashMap before access");
        accessOrder.forEach((k, v) -> System.out.println(k + " -> " + v));

        accessOrder.get(1202); // access Titanic
        System.out.println("\nAfter accessing 1202 (Titanic)");
        accessOrder.forEach((k, v) -> System.out.println(k + " -> " + v));

        accessOrder.get(1501); // access Saving Private Ryan
        System.out.println("\nAfter accessing 1501 (Saving Private Ryan)");
        accessOrder.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static void demonstrateTreeMapVariants() {
        SortedMap<Integer, String> tree = new TreeMap<>();
        tree.put(1784, "Back to the Future");
        tree.put(1503, "Titanic");
        tree.put(1202, "Jaws");
        tree.put(1501, "Forrest Gump");
        tree.put(1277, "The Godfather");

        System.out.println("***** TreeMap (natural key order)");
        tree.forEach((k, v) -> System.out.println(k + " -> " + v));

        Comparator<Integer> desc = (i1, i2) -> i2.compareTo(i1);
        SortedMap<Integer, String> descTree = new TreeMap<>(desc);
        descTree.putAll(tree);
        System.out.println("\n***** TreeMap with reverse comparator (descending keys)");
        descTree.forEach((k, v) -> System.out.println(k + " -> " + v));

        Comparator<String> byLength = Comparator.comparingInt(String::length);
        SortedMap<String, String> stringByLength = new TreeMap<>(byLength);
        stringByLength.put("Pablo Picasso", "Guernica");
        stringByLength.put("Salvador Dali", "The Persistence of Memory");
        stringByLength.put("Vincent van Gogh", "The Starry Night");
        stringByLength.put("Leonardo da Vinci", "Mona Lisa");
        System.out.println("\n***** TreeMap with String-key comparator (by key length)");
        stringByLength.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static void demonstrateTreeMapNavigation() {
        SortedMap<Integer, String> sample = new TreeMap<>();
        sample.put(1202, "Sam");
        sample.put(1503, "Tom");
        sample.put(1501, "Ronald");
        sample.put(1784, "Ursula");
        sample.put(1277, "Dan");

        System.out.println("employeesMap: " + sample);
        System.out.println("\nFirst key: " + sample.firstKey());
        System.out.println("Last key: " + sample.lastKey());
        System.out.println("\nMap with keys <1501: " + sample.headMap(1501));
        System.out.println("Map with keys >=1503: " + sample.tailMap(1503));
        System.out.println("Map with keys in [1277,1503): " + sample.subMap(1277, 1503));
    }

    private static void demonstrateCustomObjectsInMaps() {
        Map<Integer, Movie> valuesAsMovies = new HashMap<>();
        valuesAsMovies.put(1202, new Movie("Titanic", "Leonardo DiCaprio"));
        valuesAsMovies.put(1501, new Movie("Back to the Future", "Michael J. Fox"));
        valuesAsMovies.put(1884, new Movie("The Godfather", "Al Pacino"));
        valuesAsMovies.put(2932, new Movie("Casablanca", "Humphrey Bogart"));
        System.out.println("**** Values can be custom objects");
        valuesAsMovies.forEach((k, v) -> System.out.println(k + " -> " + v));

        Map<Movie, Float> keysAsMovies = new HashMap<>();
        keysAsMovies.put(new Movie("Titanic", "Leonardo DiCaprio"), 8.8f);
        keysAsMovies.put(new Movie("Back to the Future", "Michael J. Fox"), 8.3f);
        keysAsMovies.put(new Movie("The Godfather", "Al Pacino"), 9.3f);
        keysAsMovies.put(new Movie("Casablanca", "Humphrey Bogart"), 8.9f);
        System.out.println("\n**** Keys can be custom objects");
        keysAsMovies.forEach((k, v) -> System.out.format("Key: %s, Value: %.1f%n", k, v));

        System.out.println("\n**** Duplicate entry with equal Movie key (will replace previous value)");
        Movie anotherGodfather = new Movie("The Godfather", "Al Pacino");
        keysAsMovies.put(anotherGodfather, 5.4f); // replaces 9.3f if equals/hashCode match
        keysAsMovies.forEach((k, v) -> System.out.format("Key: %s, Value: %.1f%n", k, v));
    }

    private static void demonstrateLRUCache() {
        Map<Integer, String> lru = new LRUCache();
        lru.put(1784, "The Godfather");
        lru.put(1202, "Titanic");
        lru.put(1503, "Jaws");
        lru.put(1501, "Saving Private Ryan");
        lru.put(2501, "Back to the Future");

        System.out.println("***** LRUCache initial 5 entries");
        lru.forEach((k, v) -> System.out.println(k + " -> " + v));

        lru.put(3000, "Parasite");
        lru.put(4000, "It's a Beautiful Life");
        System.out.println("\nAfter adding two more entries (only 5 recent preserved):");
        lru.forEach((k, v) -> System.out.println(k + " -> " + v));

        lru.get(1503);
        lru.get(2501);
        System.out.println("\nAfter accessing 1503 and 2501:");
        lru.forEach((k, v) -> System.out.println(k + " -> " + v));

        lru.get(1501);
        System.out.println("\nAfter accessing 1501:");
        lru.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
