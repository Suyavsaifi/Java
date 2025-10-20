# 📚 Java Concepts: Constructors and Polymorphism

This document explains two fundamental concepts in Object-Oriented Programming (OOP) in Java: how **Constructors** interact within **Inheritance** hierarchies and the different forms of **Polymorphism**.

## 1\. Constructors and Inheritance

A constructor is a special method used to initialize an object. In the context of inheritance (where a **Derived Class** `extends` a **Base Class**), the constructors follow a specific invocation order and set of rules.

### Key Concepts

| Concept | Explanation |
| :--- | :--- |
| **Default, No-Argument Constructor** | If you do not define any constructor in your class, Java automatically provides a public, no-argument constructor for you. However, this automatic provision is revoked if you define *any* explicit constructor (parameterized or not). |
| **Constructor Invocation Order** | When an object of a derived class is instantiated, the **Base Class constructor is always invoked before the Derived Class constructor**. This ensures the inherited members are initialized first. |
| **The `super` Keyword** | The `super` keyword is used to access functionality from the base class when inside a derived class. When used as a function, `super()` or `super(arguments)`, it explicitly invokes a constructor of the base class. |
| **The Mandatory `super()` Call** | Java ensures that every derived class constructor calls a base class constructor. If you do not explicitly call one using `super(...)` or `this(...)`, Java automatically inserts an implicit call to the **no-argument `super()`** as the first line. |
| **The Crucial Rule** | If the **Base Class only has a Parameterized Constructor** (meaning it does *not* have a no-argument constructor), the derived class **MUST** explicitly call the base class parameterized constructor using `super(arguments)`. Java will **never** implicitly call a parameterized base class constructor for you. |

### Concrete Example: Constructor Invocation

This example demonstrates the order of constructor calls and the use of the `super` keyword to pass state from the derived class constructor to the base class.

#### 1\. Base Class: `Book.java`

```java
public class Book {
    private String name = "unknown";

    // Parameterized Constructor
    public Book(String name) {
        this.name = name; // Set state
        System.out.println("Book: Parameterized constructor invoked for " + this.name);
    }
    
    // Default No-Argument Constructor (Overloaded)
    public Book() {
        System.out.println("Book: Default no-argument constructor invoked");
    }

    public String getName() {
        return name;
    }
}
```

#### 2\. Derived Class: `SelfHelpBook.java`

```java
public class SelfHelpBook extends Book {

    // 1. Default No-Argument Constructor
    public SelfHelpBook() {
        // Java implicitly calls super() here, but we can make it explicit.
        super(); // Calls Book() constructor
        System.out.println("SelfHelpBook: Default no-argument constructor invoked");
    }

    // 2. Parameterized Constructor
    public SelfHelpBook(String name) {
        // We MUST explicitly call the parameterized base class constructor
        // to set the 'name' field, which is defined in the Base Class (Book).
        super(name); // Calls Book(String name) constructor
        System.out.println("SelfHelpBook: Parameterized constructor invoked for " + name);
    }
}
```

#### 3\. Execution (`Main.java` Output)

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Instantiating SelfHelpBook (Parameterized) ---");
        SelfHelpBook book1 = new SelfHelpBook("Algorithms to Live By");
        // Output Order:
        // 1. Book: Parameterized constructor invoked for Algorithms to Live By
        // 2. SelfHelpBook: Parameterized constructor invoked for Algorithms to Live By
        
        System.out.println("Book Name: " + book1.getName()); // Algorithms to Live By
    }
}
```

**Key Takeaway:** The constructor of the **Base Class (`Book`) is always invoked before** the constructor of the **Derived Class (`SelfHelpBook`)**.

-----

## 2\. Polymorphism

Polymorphism, meaning "**many forms**," is the ability of an object to take many forms. In Java, this occurs in two main ways: **Runtime Polymorphism** and **Compile-time Polymorphism**.

### A. Runtime Polymorphism (Dynamic Method Dispatch)

This type of polymorphism occurs at the time of program execution (runtime) and is often achieved through **Method Overriding** in an inheritance hierarchy.

| Concept | Explanation |
| :--- | :--- |
| **Definition** | Runtime polymorphism involves a **variable of a base class containing an object of a derived class**. |
| **Dynamic Method Dispatch** | This is the process where Java determines which actual implementation of an overridden method to invoke at runtime. |
| **Mechanism** | Java uses **dynamic binding** (runtime binding) to link the method call to the correct implementation based on the **actual object's type** (the derived class), rather than the reference variable's type (the base class). |

### Concrete Example: Dynamic Method Dispatch

```java
// Base Class
public class SmartSpeaker {
    protected String productName;
    public SmartSpeaker(String name) { this.productName = name; }

    public void wakePhrase() {
        System.out.println("Activates on saying " + productName + "'s wake phrase.");
    }
}

// Derived Class
public class AmazonEcho extends SmartSpeaker {
    public AmazonEcho() {
        super("Amazon Echo");
    }

    @Override
    public void wakePhrase() {
        // Overridden method
        System.out.println("Wake phrase: Alexa.");
    }
}
```

```java
public class RuntimePolymorphismDemo {
    public static void main(String[] args) {
        // Variable of Base Class (SmartSpeaker) referencing an object of Derived Class (AmazonEcho)
        SmartSpeaker speaker = new AmazonEcho(); 

        System.out.print("Invoking wakePhrase: ");
        // Which method is called is determined at runtime based on the *actual* object (AmazonEcho).
        speaker.wakePhrase(); 
        
        // Output: Wake phrase: Alexa.
    }
}
```

-----

### B. Compile-time Polymorphism (Method Overloading)

This type of polymorphism is resolved by the compiler at **compile-time** (Static Binding). [cite\_start]It is achieved by defining multiple methods with the same name but different argument lists, a concept known as **Method Overloading**[cite: 6, 24, 530, 561].

| Concept | Explanation |
| :--- | :--- |
| **Definition** | Defining multiple methods in the same class with the same name but a different **signature** (different number or type of input arguments). |
| **Method Signature** | The signature of a method consists of its name and the type/order of its parameters. **The return type does NOT count** as part of the signature; you cannot overload methods based on return type alone. |
| **Type Promotion** | When an exact match is not found for an argument, Java can perform an **implicit type promotion** to find a matching overloaded method (e.g., `short` to `int`, or `int` to `float`). |
| **Ambiguity** | If a method call matches **more than one** overloaded method (even after type promotion), the compiler cannot decide which one to use and flags an **ambiguous method call error**. |

### Concrete Example: Method Overloading

```java
public class Measure {

    // 1. Overloaded Method: Perimeter for Rectangle (int, int)
    public int perimeter(int length, int width) {
        System.out.println("-> Invoked perimeter(int, int)");
        return 2 * length + 2 * width;
    }

    // 2. Overloaded Method: Perimeter for Triangle (double, double, double) - Different # of arguments
    public double perimeter(double side1, double side2, double side3) {
        System.out.println("-> Invoked perimeter(double, double, double)");
        return side1 + side2 + side3;
    }

    // 3. Overloaded Method: Area (float, float) - Different type of arguments
    public float area(float length, float width) {
        System.out.println("-> Invoked area(float, float)");
        return length * width;
    }
}
```

```java
public class CompileTimePolymorphismDemo {
    public static void main(String[] args) {
        Measure measure = new Measure();

        // 1. Calls perimeter(int, int) - Match based on two integer arguments.
        int rectPerim = measure.perimeter(4, 3);
        System.out.println("Rectangle Perimeter (cm): " + rectPerim); // Output: 14

        // 2. Calls perimeter(double, double, double) - Match based on three double arguments.
        double triPerim = measure.perimeter(4.0, 3.0, 6.0);
        System.out.println("Triangle Perimeter (cm): " + triPerim); // Output: 13.0

        // 3. Calls area(float, float) - Match based on two float arguments.
        float areaValue = measure.area(10.5f, 5.0f);
        System.out.println("Area (sq. cm): " + areaValue); // Output: 52.5
    }
}
```