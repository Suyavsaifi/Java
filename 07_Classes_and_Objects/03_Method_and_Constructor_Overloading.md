# Java: Method & Constructor Overloading

This guide provides a concise overview of method overloading and constructors in Java, complete with definitions and code examples.

-----

## Method Overloading

**Method overloading** is a feature in Java that allows a class to have more than one method with the same name, as long as their **parameter lists are different**. It's a way to implement compile-time polymorphism.

The compiler decides which method to call based on the method signature (the method name and its parameter list). The parameter list can differ in:

1.  **Number of parameters.**
2.  **Data type of parameters.**
3.  **Sequence of data types of parameters.**

**Note:** Overloading cannot be achieved by changing only the return type of the method.

### Code Example: Method Overloading

Here's an example of a class `Display` that overloads the `show` method.

```java
// A class to demonstrate method overloading
class Display {

    // Method with one integer parameter
    public void show(int num) {
        System.out.println("Displaying integer: " + num);
    }

    // Overloaded method with one double parameter
    public void show(double num) {
        System.out.println("Displaying double: " + num);
    }

    // Overloaded method with a string and an integer parameter
    public void show(String text, int num) {
        System.out.println("Displaying string and integer: " + text + ", " + num);
    }
}

public class Main {
    public static void main(String[] args) {
        Display obj = new Display();

        // Calls the first show() method
        obj.show(100);

        // Calls the second show() method
        obj.show(100.5);

        // Calls the third show() method
        obj.show("Hello", 100);
    }
}
```

**Output:**

```
Displaying integer: 100
Displaying double: 100.5
Displaying string and integer: Hello, 100
```

-----

## Constructors & Constructor Overloading

A **constructor** in Java is a special method used to initialize objects. It is called automatically when an object of a class is created.

Key characteristics of a constructor:

  * It has the **same name as the class**.
  * It **does not have a return type**, not even `void`.
  * It is used to set initial values for object attributes.

Just like methods, constructors can also be overloaded. **Constructor overloading** means having multiple constructors in a class with different parameter lists. This provides different ways to initialize an object.

### Code Example: Constructor Overloading

This example shows a `Car` class with multiple constructors.

```java
// A class to demonstrate constructor overloading
class Car {
    String make;
    String model;
    int year;

    // 1. Default constructor (no-args)
    public Car() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }

    // 2. Constructor with two parameters
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.year = 2025; // Default year
    }

    // 3. Constructor with three parameters
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Car Info: " + year + " " + make + " " + model);
    }
}

public class Main {
    public static void main(String[] args) {
        // Calls the default constructor
        Car car1 = new Car();
        car1.displayInfo();

        // Calls the constructor with two parameters
        Car car2 = new Car("Ford", "Mustang");
        car2.displayInfo();

        // Calls the constructor with three parameters
        Car car3 = new Car("Tesla", "Model S", 2024);
        car3.displayInfo();
    }
}
```

**Output:**

```
Car Info: 0 Unknown Unknown
Car Info: 2025 Ford Mustang
Car Info: 2024 Tesla Model S
```