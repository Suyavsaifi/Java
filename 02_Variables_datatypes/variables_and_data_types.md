### 🧠 Java Primitive Data Types

In Java, primitive data types are the most basic building blocks for storing data. They are predefined by the language and hold simple, single values. Understanding them is crucial as they are the foundation for more complex data structures.

---

### 💾 The Eight Primitive Types and Memory Allocation

Java has eight primitive data types, which are categorized into four groups: integer types, floating-point types, character, and boolean. Each has a fixed size in memory, making them fast and efficient.

| Data Type | Group           | Size (in Bytes) | Default Value | Value Range                                        |
| :-------- | :-------------- | :-------------- | :------------ | :------------------------------------------------- |
| `byte`    | Integer         | 1               | 0             | -128 to 127                                        |
| `short`   | Integer         | 2               | 0             | -32,768 to 32,767                                  |
| `int`     | Integer         | 4               | 0             | -2,147,483,648 to 2,147,483,647                    |
| `long`    | Integer         | 8               | 0L            | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 |
| `float`   | Floating-point  | 4               | 0.0f          | Up to 7 decimal digits of precision                |
| `double`  | Floating-point  | 8               | 0.0d          | Up to 15 decimal digits of precision               |
| `char`    | Character       | 2               | '\u0000'      | 0 to 65,535 (Unicode characters)                   |
| `boolean` | Boolean         | 1 bit ( JVM specific ) | false         | `true` or `false`                                  |

---

### 🏛️ Memory Storage for Primitive Types

The location where a primitive data type is stored depends on where it is declared.

* **Stack Memory:** Primitive variables declared inside a method are stored in the **stack** memory. This is because stack memory is used for method execution and local variables. When a method is called, a new stack frame is created, and all local variables, including primitive types, are stored within it. Once the method finishes, its stack frame is destroyed, and the memory is automatically reclaimed.
* **Heap Memory:** Primitive variables that are part of an object (instance variables) are stored in the **heap** memory. The object itself resides in the heap, and all of its data, including its primitive instance variables, are stored alongside it. The heap is used for dynamic memory allocation, and objects remain in memory until they are no longer referenced and are garbage-collected.
* **Method Area (or PermGen/Metaspace):** Primitive variables that are declared as `static` (class variables) are stored in the **Method Area** (or its modern equivalent, Metaspace). This area of memory holds class-level data, including static variables, which are shared by all instances of a class. The space for these variables is allocated when the class is loaded and remains until the class is unloaded.  


### 📜 Strings in Java

In Java, a **String** is a sequence of characters. Unlike primitive data types, `String` is an object, which means it's an instance of the `java.lang.String` class. Strings are immutable, meaning once a String object is created, its content cannot be changed. Any operation that appears to modify a string, like concatenation, actually creates a new String object.

#### **Declaring and Initializing Strings**

There are two main ways to create a String object:

1.  **Using a String literal:** This is the most common way. The JVM uses a special memory area called the **String Pool** to store these literals, which helps in saving memory by reusing existing String objects.

    ```java
    String greeting = "Hello, World!";
    ```

2.  **Using the `new` keyword:** This creates a new String object in the **heap memory**, regardless of whether the same string already exists in the String Pool.

    ```java
    String name = new String("Java");
    ```

-----

### 🗂️ Arrays in Java

An **Array** is a container object that holds a fixed number of values of a single data type. The elements of an array are stored in a contiguous block of memory. Arrays are also objects in Java, so they are always created on the **heap memory**.

#### **Declaring and Initializing Arrays**

1.  **Declaration:** Declaring an array variable simply creates a reference that can point to an array.

    ```java
    int[] numbers; // Declares an array of integers
    ```

2.  **Initialization:** To create the array itself, you must use the `new` keyword and specify its size. The elements are automatically initialized to their default values (e.g., `0` for numeric types, `false` for boolean, and `null` for objects).

    ```java
    numbers = new int[5]; // Creates an array of 5 integers
    ```

    You can also declare and initialize an array in one go:

    ```java
    String[] fruits = {"Apple", "Banana", "Orange"}; // Array of strings
    ```

#### **Accessing Array Elements**

Array elements are accessed using a zero-based index.

```java
public class ArrayExample {
    public static void main(String[] args) {
        int[] scores = new int[3];

        // Assigning values to array elements
        scores[0] = 95;
        scores[1] = 88;
        scores[2] = 76;

        // Accessing and printing an element
        System.out.println("The score at index 1 is: " + scores[1]);

        // Looping through an array
        System.out.println("All scores:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Score " + (i + 1) + ": " + scores[i]);
        }
    }
}
```