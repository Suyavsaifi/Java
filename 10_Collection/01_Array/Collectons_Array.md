### Course Summary: Arrays and Non-parameterized ArrayLists

This document extracts the key definitions, characteristics, rules, and runnable code examples

---

### Core definitions and key points

- **Array**  
  - Fixed-length, ordered container for elements of a single declared type (primitive or reference).  
  - Declared with square brackets. Example: `int[] arr = new int[4];`  
  - Indexing starts at 0; last index is `length - 1`.  
  - Arrays are objects in Java; `someArray instanceof Object` is true for primitive and reference arrays.  
  - Default values: primitives → zero (0, 0.0); object references → `null`.  
  - Use `array.length` (no parentheses) to get the array size.  
  - `Arrays.toString(array)` prints contents; default `toString()` for arrays prints class info and memory hash, not contents.

- **Zero-length array**  
  - Can be created using `new Type[0]` or an empty initializer `new Type[] {}`. Indexing into one causes `ArrayIndexOutOfBoundsException`.

- **Multidimensional array**  
  - A "2D array" like `int[][] matrix = new int[3][4];` is an array-of-arrays. Rows can be arrays of different lengths (jagged arrays).  
  - Access syntax uses multiple bracket pairs, e.g., `matrix[row][col]`.

- **Jagged array**  
  - Outer dimension defined, inner arrays allocated separately with possibly different lengths (e.g., `String[][] s = new String[3][]; s[0] = new String[2]; s[1] = new String[3];`).

- **Object[] (mixed arrays)**  
  - `Object[]` allows mixed types but forfeits compile-time type checking. Access requires casting and is error-prone. Prefer generics/typed collections.

- **Arrays as manual collections**  
  - Adding/removing elements requires manual bookkeeping (e.g., a `lastIndex` pointer). Removing requires shifting subsequent elements left; adding must check capacity. This is error-prone and why higher-level collections exist.

- **List / ArrayList (non-parameterized / raw type)**  
  - `List` is an ordered collection interface; `ArrayList` is a resizable array-backed implementation.  
  - Raw (non-parameterized) `ArrayList` stores and returns `Object`. This loses compile-time type safety and causes casts and runtime errors. Prefer parameterized generics (e.g., `ArrayList<String>`).  
  - Common methods: `add`, `remove`, `size`, `isEmpty`, `contains`, `get` (index-based). These methods are defined in `List` and `Collection` interfaces. `Iterable` only supports iteration (no size/add/remove).

- **Non-parameterized pitfalls**  
  - Mixing types in a raw collection causes boxing/unboxing and wrapper types (e.g., `int` → `Integer`). Casting errors occur at runtime when misuse happens (e.g., casting a `Double` to `Integer`).

---

### Practical rules & instructor talking points

- Always declare arrays with known length or initialize with explicit values; leaving `new Type[]` without initializer causes compile error.
- Use `Arrays.toString(...)` or `Arrays.deepToString(...)` (for nested arrays) to display contents.
- Iterate arrays safely: prefer `for (int i = 0; i < arr.length; i++)` or enhanced for loop `for (T item : arr)` to avoid off-by-one errors.
- Use `Object[]` or raw collections only to demonstrate risks; always prefer generics in production code.
- Explain memory implication: arrays allocate full capacity upfront — wasteful if sparsely used.
- Show deleting from array implementation to motivate `ArrayList` (automatic resizing and remove semantics).

---

### Code examples

- Arrays: primitives, objects, viewing class and contents
```java
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] intArray = new int[4];
        intArray[0] = 10;
        intArray[1] = 20;
        System.out.println("Array of integers: " + intArray);                // default toString (not contents)
        System.out.println("getClass(): " + intArray.getClass());
        System.out.println("toString(): " + intArray.toString());
        System.out.println("Contents: " + Arrays.toString(intArray));       // proper contents display

        float[] floatArray = new float[6];
        floatArray[0] = 10.5f;
        floatArray[3] = 20.5f;
        System.out.println("Float array contents: " + Arrays.toString(floatArray));

        String[] stringArray = new String[7];
        stringArray[1] = "Good";
        stringArray[2] = "Morning";
        System.out.println("String array class: " + stringArray.getClass());
        System.out.println("String array contents: " + Arrays.toString(stringArray));
    }
}
```

- Fixed-length and zero-length arrays; index rules
```java
public class ArrayLengthDemo {
    public static void main(String[] args) {
        String[] companies = {"Amazon", "Google", "Microsoft", "Facebook"};
        System.out.println("companies length: " + companies.length);
        System.out.println("companies[0]: " + companies[0]);
        // companies[4] -> ArrayIndexOutOfBoundsException

        String[] empty1 = new String[] {};     // zero-length array
        String[] empty2 = new String[0];       // zero-length array
        System.out.println(empty1.length);     // 0
        System.out.println(empty2.length);     // 0
        // empty1[0] -> ArrayIndexOutOfBoundsException
    }
}
```

- Safe iteration: index-based and enhanced for
```java
public class IterateDemo {
    public static void main(String[] args) {
        String[] companies = {"Amazon", "Google", "Microsoft", "Facebook"};

        // Safe index-based loop
        for (int i = 0; i < companies.length; i++) {
            System.out.format("companies[%d] : %s%n", i, companies[i]);
        }

        // Enhanced for loop (no index)
        for (String company : companies) {
            System.out.format("company %s%n", company);
        }
    }
}
```

- Mixed Object[] example (demonstrate runtime casting risk)
```java
public class MixedArrayDemo {
    public static void main(String[] args) {
        Object[] mixed = {"Amazon", 100.0f, 23, true};
        for (Object o : mixed) {
            System.out.println(o.getClass() + " -> " + o);
        }

        // Dangerous casting (illustrate error scenarios)
        try {
            Integer n = (Integer) mixed[1]; // ClassCastException: Float cannot be cast to Integer
        } catch (ClassCastException e) {
            System.out.println("Casting error: " + e.getMessage());
        }
    }
}
```

- Manual array-as-collection: add and delete helpers (illustrates complexity)
```java
import java.util.Arrays;

public class ArrayCollection {
    private static String[] container = new String[5];
    private static int lastIndex = 0;

    public static void addString(String e) {
        if (lastIndex >= container.length) {
            System.out.println("Cannot add element, no room in array!");
            return;
        }
        container[lastIndex++] = e; // add then increment
    }

    public static void deleteString(int index) {
        if (index < 0 || index >= container.length) {
            System.out.println("Index out of bounds, cannot delete");
            return;
        }
        container[index] = null; // remove element
        int current = index;
        for (int i = index; i < container.length - 1; i++) {
            container[current] = container[current + 1];
            current++;
        }
        container[container.length - 1] = null; // clear duplicated last
        lastIndex = Math.max(0, lastIndex - 1);
    }

    public static void main(String[] args) {
        addString("Amazon");
        System.out.println(Arrays.toString(container));
        addString("Skillsoft");
        addString("SumTotal");
        addString("Suzuki");
        System.out.println(Arrays.toString(container));
        deleteString(0); // remove Amazon
        System.out.println(Arrays.toString(container));
        deleteString(1); // remove SumTotal (after shift)
        System.out.println(Arrays.toString(container));
        addString("Optum");
        System.out.println(Arrays.toString(container));
    }
}
```

- Multidimensional arrays and jagged arrays
```java
import java.util.Arrays;

public class MultiDimDemo {
    public static void main(String[] args) {
        int[][] twoD = new int[3][4]; // 3 rows, 4 cols
        twoD[0][0] = 100;
        twoD[1][1] = 200;
        twoD[2][2] = 300;
        for (int[] row : twoD) {
            System.out.println(Arrays.toString(row));
        }

        // Jagged array
        String[][] jagged = new String[3][];
        jagged[0] = new String[2];
        jagged[1] = new String[3];
        jagged[2] = new String[4];
        jagged[0][0] = "Ron";
        jagged[1][2] = "Harry";
        jagged[2][3] = "Hermione";
        for (String[] row : jagged) {
            System.out.println(Arrays.toString(row));
        }
    }
}
```

- Non-parameterized ArrayList (raw type) example and issues
```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RawListDemo {
    public static void main(String[] args) {
        // Raw (non-parameterized) ArrayList
        ArrayList raw = new ArrayList();
        System.out.println("Initial: " + raw);
        System.out.println("isEmpty(): " + raw.isEmpty());

        raw.add("EUR");
        raw.add("USD");
        raw.add("GBP");
        raw.add("JPY");
        raw.add("INR");
        System.out.println("Contents: " + raw);
        System.out.println("size(): " + raw.size());

        raw.remove("EUR");
        raw.remove("GBP");
        System.out.println("After remove: " + raw + ", size: " + raw.size());

        System.out.println("contains USD? " + raw.contains("USD"));

        // As a List or Collection variable type (methods are available)
        List asList = raw;           // methods like get, add, remove available
        Collection asCollection = raw;

        // Danger: mixed types
        raw.add(12);
        raw.add(452.45);
        raw.add(true);

        // Access requires casting and may throw ClassCastException
        try {
            int a = (Integer) raw.get(2); // OK if element is Integer
            System.out.println("Sum: " + (a + (Integer) raw.get(3)));
        } catch (ClassCastException e) {
            System.out.println("Runtime cast error: " + e.getMessage());
        }
    }
}
```