**Hello World Java Program**

Here's an explanation of the "Hello World" Java program.

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

-----

### 📜 **Code Explanation**

* **`public class HelloWorld`**

    * This line declares a new **public** class named **`HelloWorld`**.
    * A public class must be defined in a file with the same name, so this code should be in a file named `HelloWorld.java`. This convention helps the Java compiler easily identify the public class before reading the file's content.

* **`public static void main(String[] args)`**

    * This is the **main method**, which is the entry point for the program.
    * **`public`**: This keyword defines the method's scope. Being public, the Java Virtual Machine (JVM) or other external programs can call this method.
    * **`static`**: This keyword defines the method's state. A static method can be called without needing to create an object of the class first.
    * **`void`**: This keyword indicates that the method does not return any value.
    * **`String[] args`**: This specifies that the method accepts an array of strings as arguments, which can be passed from the command line when the program is executed.

* **`System.out.println("Hello World")`**

    * This line prints the string **"Hello World"** to the console.
    * **`System.out`** represents the standard output, which is typically the console.
    * **`.println()`** is a method that takes a string as input and prints it to the console output.