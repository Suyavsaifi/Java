### Lists and list operations — key definitions and concepts

- **List (Java)** — an ordered collection that allows duplicates; every element has an index (0..n-1). Use lists when order and positional access matter.
- **ArrayList** — the most common List implementation; backed by an array and resized automatically by the class (client code does not manually reallocate).
- **Collection (interface)** — general container interface that provides core collection operations: add, addAll, remove, removeAll, contains, containsAll, size, isEmpty, clear, iterator.
- **List (interface)** — extends Collection; adds index-based operations and list-specific behaviors: get(index), add(index, element), remove(index), indexOf, lastIndexOf, set(index, element), subList.
- **Iterable (interface)** — root abstraction that exposes an Iterator; enables for-each loops. Iterable → provides iterator() which returns Iterator.
- **Iterator (interface)** — navigate an Iterable in sequence with hasNext() and next(); optional remove() supported by some iterators.
- **Parameterized (generic) list** — List<T> where T is the element type. Generics give compile-time type safety and eliminate casting.
- **Non-parameterized (raw) list** — List or ArrayList used without a type argument; stores Object, loses compile-time checks and requires casting when reading elements.
- **Primitive types vs generics** — generic type arguments must be reference types (Integer not int). Primitive values are autoboxed into their wrapper classes when added to collections.
- **Nulls** — Lists can contain null elements (unless implementation forbids it).
- **Duplicates** — allowed in List; sets differ by disallowing duplicates.
- **IndexOutOfBounds / ArrayIndexOutOfBounds** — thrown when accessing or removing with invalid indices.

---

### Why prefer parameterized lists (summary)
- **Compile-time type safety** (prevents adding wrong types).
- **No casts when reading elements** (cleaner code, fewer runtime errors).
- Better intention-revealing APIs for students and maintainers.

---

### Core list operations (short reference)

- Creation
  - ArrayList: new ArrayList<>(); or new ArrayList<T>()
  - List variable type recommended: List<T> list = new ArrayList<>();
- Add
  - add(element), add(index, element), addAll(collection)
- Remove
  - remove(element), remove(index), removeAll(collection)
- Read / Index
  - get(index), set(index, element), indexOf(element), lastIndexOf(element)
- Queries
  - contains(element), containsAll(collection), size(), isEmpty()
- Iteration
  - for-each, Iterator<T> with hasNext()/next()

---

### Example code snippets with explanations

#### 1) Basic parameterized list (String)
```java
List<String> currencies = new ArrayList<>();
currencies.add("EUR");
currencies.add("USD");
currencies.add("INR");

// read, size check
System.out.println(currencies);            // [EUR, USD, INR]
System.out.println(currencies.size());     // 3
System.out.println(currencies.contains("EUR")); // true
```
- Explanation: Generics enforce that only Strings can be added. No casts required when reading.

#### 2) Custom object list (Car) with safe iteration
```java
class Car {
    private final String make;
    private final String model;
    private final double price;

    public Car(String make, String model, double price) {
        this.make = make; this.model = model; this.price = price;
    }

    public String getMake()  { return make; }
    public String getModel() { return model; }
    public double getPrice() { return price; }

    @Override public String toString() {
        return String.format("Make:%s Model:%s Price:%.2f", make, model, price);
    }
}

// usage
List<Car> cars = new ArrayList<>();
cars.add(new Car("Honda", "Civic", 21000.0));
cars.add(new Car("Toyota", "Camry", 29000.0));
cars.add(new Car("BMW", "5 Series", 65000.0));

// safe iteration
for (Car c : cars) {
    System.out.printf("%s, %s, %.1f%n", c.getMake(), c.getModel(), c.getPrice());
}
```
- Explanation: Parameterized List<Car> guarantees elements are Car; methods of Car are available without casting.

#### 3) List index operations (List-specific)
```java
List<String> cities = new ArrayList<>();
cities.add("Bengaluru");
cities.add("New York");
cities.add("Mumbai");

// insert by index
cities.add(0, "Seattle");        // insert at index 0
cities.add(2, "Palo Alto");      // insert at index 2

// access by index
String first = cities.get(0);

// remove by index
cities.remove(0);                // removes element at index 0

// find indices
int firstIndex = cities.indexOf("Palo Alto");
int lastIndex  = cities.lastIndexOf("Bengaluru");
```
- Explanation: Index-based methods belong to List interface (not Collection/Iterable). Accessing an invalid index throws IndexOutOfBoundsException.

#### 4) Bulk operations and membership checks
```java
List<String> mainList = new ArrayList<>(List.of("A", "B", "C"));
List<String> extra    = new ArrayList<>(List.of("X", "Y"));
mainList.addAll(extra);                // append all
boolean hasBoth = mainList.containsAll(extra);
mainList.removeAll(extra);             // remove all elements contained in extra
```
- Explanation: addAll/containsAll/removeAll are Collection methods (available on List, Set, etc.).

#### 5) Iterator usage (manual)
```java
Iterable<String> iterable = List.of("one", "two", "three");
Iterator<String> it = iterable.iterator();
while (it.hasNext()) {
    String s = it.next();
    System.out.println(s);
}
// calling next() when hasNext() is false throws NoSuchElementException
```
- Explanation: for-each uses iterator under the hood; explicit Iterator allows finer control (and optional remove()).

#### 6) Non-parameterized list pitfalls (do NOT use in new code)
```java
List raw = new ArrayList();   // raw / non-parameterized
raw.add("EUR");
raw.add(100);                // allowed at compile-time

Object o = raw.get(1);       // returns Object
// to use as Integer you must cast -> runtime risk
int n = (Integer) raw.get(1); // OK here; but unsafe if types mismatch
```
- Explanation: raw lists remove compile-time checks and push type errors to runtime. Avoid unless maintaining legacy code.

#### 7) Generics must use reference types (wrapper types for primitives)
```java
List<Integer> ints = new ArrayList<>();
ints.add(100);         // autoboxes to Integer.valueOf(100)
ints.add(null);        // allowed (null element)
```
- Explanation: You cannot use List<int>; use List<Integer>. Primitive values are autoboxed when added to collections.