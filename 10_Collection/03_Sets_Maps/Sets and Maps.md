### Sets and Maps

---

### Core definitions

- **Set**: An unordered collection of unique elements; no duplicates allowed. Implementations: HashSet, LinkedHashSet, TreeSet.
- **Map**: A collection of key→value mappings where keys are unique and values may repeat. Implementations: HashMap, LinkedHashMap, TreeMap.
- **Equality for hash-based collections**: Hash-based sets/maps use an object’s `equals()` and `hashCode()` to determine duplicate keys/elements. If you override `equals()` you must override `hashCode()` to satisfy the contract.
- **Comparable**: An interface for objects that have a natural ordering; implement `compareTo(T o)`.
- **Comparator**: A separate object you pass to a sorted collection to define custom ordering; implement `compare(T a, T b)`.
- **SortedSet / SortedMap**: Interfaces for collections that expose ordering operations (first, last, headSet, tailSet, subSet for sets; firstKey, lastKey, headMap, tailMap, subMap for maps).
- **LinkedHashSet / LinkedHashMap**: Maintain insertion order; LinkedHashMap supports an access-order mode to implement LRU caches.
- **TreeSet / TreeMap**: Red‑black tree implementations that require elements/keys to be comparable or a Comparator provided; do not accept null keys (TreeSet/TreeMap).
- **LRU Cache (Least Recently Used)**: Fixed-size cache that evicts least-recently accessed entry; LinkedHashMap with accessOrder=true plus overriding `removeEldestEntry` is a simple implementation.

---

### Sets — key operations and behaviors

- Create: `Set<String> s = new HashSet<>();`
- Add: `s.add(x)` — duplicates ignored (detected via `equals()` + `hashCode()`).
- Remove: `s.remove(x)`.
- Union: `a.addAll(b)` → result in `a`.
- Intersection: `a.retainAll(b)` → `a` becomes intersection.
- Difference: `a.removeAll(b)` → `a` minus elements in `b`.
- Null handling:
  - HashSet allows one `null` (nulls are equal to one another).
  - TreeSet does **not** accept null (NullPointerException) because it has ordering.

Example: basic set operations
```java
Set<String> cars = new HashSet<>(Arrays.asList("Volvo","BMW","Ford"));
Set<String> bikes = new HashSet<>(Arrays.asList("Suzuki","Yamaha","BMW"));

cars.addAll(bikes);           // union
cars.retainAll(bikes);        // intersection
cars.removeAll(bikes);        // difference
```

Equality / duplicate example (custom objects)
- Always override both `equals(Object o)` and `hashCode()` for objects used in HashSet/HashMap keys:
```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Product)) return false;
    Product p = (Product) o;
    return Objects.equals(name, p.name) && Objects.equals(category, p.category);
}
@Override
public int hashCode() {
    return Objects.hash(name, category);
}
```
Without these, two logically-equal objects can be stored twice in a HashSet.

---

### Set implementations and ordering (teaching points)

- HashSet
  - Unordered, fast (hash lookups).
- LinkedHashSet
  - Hash-based with insertion-order iteration (or access-order if configured).
- TreeSet
  - Sorted; uses natural order (Comparable) or a provided Comparator.
  - Slower than HashSet/LinkedHashSet.
  - Does not accept null keys/elements.

TreeSet range helpers (SortedSet):
- `first()`, `last()`, `headSet(toElement)`, `tailSet(fromElement)` (inclusive/exclusive rules vary), `subSet(from, to)`.

Comparables vs Comparators:
- If element class implements `Comparable<T>` then TreeSet can use natural ordering.
- If you cannot modify class (library type), pass a `Comparator<T>` to the TreeSet constructor.

Comparator example (reverse String order)
```java
Comparator<String> desc = (a,b) -> b.compareTo(a);
TreeSet<String> ts = new TreeSet<>(desc);
ts.addAll(Arrays.asList("Volvo","BMW","Honda","Audi","Mercedes"));
```

---

### Maps — key operations and behaviours

- Create: `Map<Integer,String> m = new HashMap<>();`
- Put/Update: `m.put(key, value)` — if key exists, value updated.
- Get: `m.get(key)` returns value or `null` if key absent.
- Remove by key: `m.remove(key)`.
- Key uniqueness: keys must be unique; values may repeat.
- Nulls:
  - HashMap/LinkedHashMap: allow one null key and any number of null values (null key counts as a single unique key).
  - TreeMap: does not accept null keys (needs ordering).
- Views:
  - `m.entrySet()` → Set<Map.Entry<K,V>> (iterator elements are `Map.Entry` objects; `entry.setValue(...)` updates the map).
  - `m.keySet()` → Set<K> (unique keys).
  - `m.values()` → Collection<V> (values may contain duplicates).

Iteration / update via entrySet:
```java
for(Map.Entry<Integer,String> e : movies.entrySet()) {
    if (e.getKey() == 1884) e.setValue("The Godfather II");
}
```

Map ordering (implementations):
- HashMap — unordered iteration.
- LinkedHashMap — insertion-order iteration; when constructed with accessOrder=true, iteration order is access order (useful for LRU).
- TreeMap — sorted by key (natural order or Comparator provided); cannot have null keys.

---

### Using custom objects as keys (important `equals`/`hashCode` reminder)

If you use a custom class as a key:

- Override `equals(Object)` and `hashCode()` consistently, using the fields that define identity.
- Example for Movie key → rating map:
```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Movie)) return false;
    Movie m = (Movie) o;
    return Objects.equals(name, m.name) && Objects.equals(actor, m.actor);
}
@Override
public int hashCode() {
    return Objects.hash(name, actor);
}
```
If you fail to override these, logically-equal keys produce duplicate map entries instead of updating the existing entry.

---

### TreeMap and Comparator gotchas (teaching caution)

- Supplying a Comparator that conflates distinct keys (e.g., comparing only length of String) can make different keys appear equal — the TreeMap will treat them as the same key and update the stored value unexpectedly. Show students the "string-length comparator" example to demonstrate unexpected key collisions.

---

### Implementing an LRU cache using LinkedHashMap

Key idea:
- Extend LinkedHashMap with constructor `LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)` set `accessOrder=true`.
- Override `removeEldestEntry(Map.Entry<K,V> eldest)` to evict when size exceeds max.

Copy‑paste LRU cache (Integer→String example)
```java
public class LRUCache extends LinkedHashMap<Integer,String> {
    private static final long serialVersionUID = 1L;
    private final int MAX_ENTRIES = 5;
    public LRUCache() {
        super(16, 0.75f, true); // accessOrder = true
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,String> eldest) {
        return size() > MAX_ENTRIES;
    }
}
```
Usage:
```java
LRUCache cache = new LRUCache();
cache.put(1784,"The Godfather");
cache.put(1202,"Titanic");
cache.put(1503,"Jaws");
cache.put(1501,"Saving Private Ryan");
cache.put(2501,"Back to the Future");

// add two more — oldest accessed/inserted items evicted
cache.put(3001,"The Parasite");
cache.put(3101,"It's a Wonderful Life");

// access to change recency
cache.get(1503); // moves 'Jaws' to most recently used
```

Teaching tip: show insertion-order vs access-order by calling `cache.get(k)` between printouts.

---

### TreeSet / TreeMap with Comparators and Comparables — examples

1) Product implements Comparable (compare by name, then category)
```java
public class Product implements Comparable<Product> {
    private final String name;
    private final String category;
    // constructor, getters, equals/hashCode as before

    @Override
    public int compareTo(Product o) {
        int cmp = this.name.compareTo(o.name);
        if (cmp != 0) return cmp;
        return this.category.compareTo(o.category);
    }
}
```
Then:
```java
SortedSet<Product> set = new TreeSet<>();
set.add(phone); set.add(tv); set.add(jeans);
```

2) Using a Comparator when you cannot modify class:
```java
Comparator<Product> comp = Comparator.comparing(Product::getName)
                                     .thenComparing(Product::getCategory);
SortedSet<Product> set = new TreeSet<>(comp);
```

3) TreeMap with custom key Comparator (descending integer keys)
```java
Comparator<Integer> desc = (a,b) -> b.compareTo(a);
Map<Integer,String> map = new TreeMap<>(desc);
map.put(1202,"Jaws"); map.put(1784,"Back to the Future");
// iteration gives keys descending
```

Teaching caution: bad Comparator (e.g., comparing only `s1.length() - s2.length()`) can make distinct keys collide — TreeMap will act like duplicates and update existing entry.

---

### SortedMap (TreeMap) operations — ranges

- `firstKey()`, `lastKey()` — min/max keys.
- `headMap(toKey)` — keys strictly less than `toKey`.
- `tailMap(fromKey)` — keys greater than or equal to `fromKey`.
- `subMap(fromKey, toKey)` — keys in [fromKey, toKey) (begin inclusive, end exclusive).
Example:
```java
SortedMap<Integer,String> m = new TreeMap<>();
m.put(1202,"Sam"); m.put(1503,"Tom"); m.put(1501,"Ronald"); m.put(1784,"Ursula"); m.put(1277,"Dan");
m.headMap(1501);          // keys < 1501
m.tailMap(1503);          // keys >= 1503
m.subMap(1277, 1503);     // [1277, 1503)
```

---

### Useful code patterns to teach (compact)

- Iterate map entries and update a value:
```java
for (Map.Entry<Integer, String> e : movies.entrySet()) {
    if (e.getKey().equals(1884)) e.setValue("The Godfather II");
}
```

- Map with custom object keys (ensure equals/hashCode):
```java
Map<Movie,Float> ratings = new HashMap<>();
ratings.put(new Movie("Godfather","Al Pacino"), 9.3f);
Movie another = new Movie("Godfather","Al Pacino");
ratings.put(another, 5.4f); // will update only if Movie.equals/hashCode implemented correctly
```

- TreeSet using Comparator to reverse natural order:
```java
TreeSet<String> desc = new TreeSet<>((a,b) -> b.compareTo(a));
desc.addAll(Arrays.asList("Volvo","BMW","Honda","Audi","Mercedes"));
```

- Example equals/hashCode skeleton (students must copy)
```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Movie)) return false;
    Movie m = (Movie)o;
    return Objects.equals(name, m.name) && Objects.equals(actor, m.actor);
}
@Override
public int hashCode() {
    return Objects.hash(name, actor);
}
```