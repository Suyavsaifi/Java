## 🍪 1. Static vs. Instance Members

In Java, members (fields/variables and methods) can belong to either the class itself or to a specific instance (object) of that class.

| Feature | Instance Member (Non-Static) | Static Member |
| :--- | :--- | :--- |
| **Ownership** | Belongs to a specific **object** (instance). | Belongs to the **class** itself. |
| **Memory** | Each object gets its **own copy** of the variable. | There is only **one copy** shared by all objects of the class. |
| **Access** | Accessed via an **object reference** (`c1.id`). | Accessed via the **Class name** (`Cookie.cookieType`). |
| **Use Case** | Modeling the **state** of an individual object (e.g., a specific user's ID or cart). | Modeling **shared state** or utilities for the class (e.g., a shared constant, a counter, a factory method). |

### Static Method Rules (Crucial for Students)

A `static` method can:

* Access and invoke other **static** members (fields or methods).
* Be invoked using the Class name (`Cookie.getCookieType()`).

A `static` method **cannot** (because it is not tied to a specific object):

* Directly access **non-static (instance)** fields or methods.
* Use the `this` keyword to refer to the current object.

### The `final` Keyword

The `final` keyword is a modifier that prevents change:

* **On a variable:** The variable's value, once initialized, cannot be changed (**unassignable**).
* **On a method:** The method cannot be **overridden** by a subclass.
* **On a class:** The class cannot be **extended** (no other classes can inherit from it).

### Java Code: Static Members and Auto-Counting

The following code demonstrates how a `static` field can be used to assign a **unique ID** (auto-counting) to each object and how a shared `static` variable affects all objects.

**`Cookie.java`**

```java
public class Cookie {
    // Instance Fields: Object-specific data
    private String id;
    private String userName;
    private int itemsInCart;

    // Static Field: Class-level data, shared by all objects
    private static String cookieType = "SESSION_COOKIE"; 
    // Static field for auto-incrementing unique IDs [cite: 8]
    private static int uniqueIdGenerator = 10001; 

    // Constructor: Assigns a unique ID to the instance field
    public Cookie(String userName, String sessionKey, int itemsInCart) {
        // Assign ID and then use the post-increment operator (++) to advance the static field [cite: 8]
        this.id = "cookieId-" + uniqueIdGenerator++; 
        this.userName = userName;
        this.itemsInCart = itemsInCart;
    }
    
    // Static Getter: The recommended way to access a static field [cite: 7]
    public static String getCookieType() {
        return cookieType; 
    }

    // Static Setter: The recommended way to modify a static field [cite: 7]
    public static void setCookieType(String newCookieType) {
        Cookie.cookieType = newCookieType; // Use ClassName for best practice [cite: 7]
    }
    
    // Overriding toString() for descriptive output [cite: 2]
    @Override
    public String toString() {
        return String.format("Cookie {id: %s, user: %s, cart: %d, type: %s}",
                             id, userName, itemsInCart, cookieType);
    }
}
```

**`Main.java` (Demonstration of Static Sharing)**

```java
public class Main {
    public static void main(String[] args) {
        Cookie c1 = new Cookie("Alice22", "ali@22", 2); 
        Cookie c2 = new Cookie("Bob667", "B#t12", 0);
        
        System.out.println("--- Initial State ---");
        System.out.println("c1 ID: " + c1.toString()); // ID: cookieId-10001
        System.out.println("c2 ID: " + c2.toString()); // ID: cookieId-10002
        
        // Change the static field using the Class name (best practice) [cite: 7]
        Cookie.setCookieType("LOGGED_IN_USER_COOKIE");
        
        System.out.println("\n--- State After Static Update ---");
        // The change is reflected in all objects, proving the shared nature of 'cookieType' [cite: 3]
        System.out.println("c1 New Type: " + c1.toString()); 
        System.out.println("c2 New Type: " + c2.toString());
    }
}
```

-----

## 🔄 2. Argument Passing Semantics in Java

Java is **strictly pass-by-value**, meaning a copy of the argument is passed to the method. However, the *type* of value being copied leads to different behaviors:

### Primitives (e.g., `int`, `double`, `boolean`)

* The **value** itself is copied.
* Changes made to the primitive variable *inside* the method are **lost** once the method returns.

### Objects (References)

* The **reference** (memory address) to the object is copied (pass-by-value of the reference).
* **Modification is Preserved:** If you use the copied reference to call a setter or change a field (`obj.setField("new_value")`), the object *contents* are changed, and this modification **persists** outside the method.
* **Reassignment is Lost:** If you reassign the reference variable itself inside the method (`obj = new OtherObject()`), the change is **lost** outside the method. The original reference variable in the calling method still points to the original object.

**Note on Arrays and Collections:** Arrays and collection objects (like `ArrayList`) behave like objects. Modifications to their *contents* (e.g., changing an element in an array) are **preserved**, but reassigning the array variable itself (e.g., `array = new int[0]`) is **lost** outside the method.

-----

## ⚖️ 3. Method Overriding: `.equals()` and `.hashCode()`

The base class for all Java objects, `java.lang.Object`, defines the `equals()` and `hashCode()` methods. When you create your own class, you often need to override these for correct behavior.

### `==` vs. Default `.equals()`

* The `==` operator checks for **identity** (whether two object references point to the exact same memory location).
* The default `Object.equals()` method performs the same check as `==`.

To check for **semantic equality** (if two objects have the same *data*), you must override the `equals()` method.

### The `hashCode()` Contract

If you override `equals()`, you **must** also override `hashCode()` to maintain the HashCode Contract.

> **The HashCode Contract:** If the `equals()` method evaluates to `true` when invoked on two objects, then their `hashCode()` values **must** be the same.

If you violate this contract, your objects will behave unpredictably when used in Java containers like `HashMap`, `HashSet`, or `Hashtable`.

### Java Code: Overriding `.equals()` and `.hashCode()`

This example (using a `Product` class mentioned in the source ) shows how to implement semantic equality and honor the contract using the built-in `Objects.hash()` utility.

**`Product.java`**

```java
import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private double price;
    private String category;

    public Product(String id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    // It is good practice to include the @Override annotation [cite: 2]
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // Check if the passed object is null or not of the same class
        if (o == null || getClass() != o.getClass()) return false;
        
        // Cast the object to the Product class
        Product product = (Product) o;
        
        // Check for semantic equality (compare the fields that define the object's 'value')
        return Double.compare(product.price, price) == 0 &&
               Objects.equals(id, product.id) &&
               Objects.equals(name, product.name) &&
               Objects.equals(category, product.category);
    }
    
    // Override hashCode() to comply with the contract [cite: 14, 15]
    @Override
    public int hashCode() {
        // Use the Objects.hash helper, passing in the SAME fields used in equals() [cite: 15]
        return Objects.hash(id, name, price, category); 
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + "]";
    }
}
```

]**Key Takeaway for Students:** Always check for **semantic equality** by comparing key fields in `equals()`, and ensure `hashCode()` returns a value computed from the **exact same fields**.