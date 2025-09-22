# Java `Scanner` Class

The **`java.util.Scanner`** class is a simple text scanner that can parse primitive types and strings using regular expressions. It is primarily used to get user input, but it can also read from files and other input streams.

## Importing the `Scanner` Class

Before you can use the `Scanner` class, you must import it into your program. This is done by adding the following line at the beginning of your Java file:

```java
import java.util.Scanner;
```

-----

## Taking User Input

To get user input, you first need to create an object of the `Scanner` class. The `System.in` object is passed as an argument to the `Scanner` constructor to tell it to read input from the standard input stream (the keyboard).

```java
// Create a Scanner object
Scanner input = new Scanner(System.in);
```

After creating the `Scanner` object, you can use its various methods to read different types of data from the user. It's a good practice to prompt the user for input using `System.out.print()` or `System.out.println()`.

### Reading a String

To read a single word (token) from the user, use the `next()` method. To read an entire line of text, including spaces, use the `nextLine()` method.

**Code Snippet:**

```java
import java.util.Scanner;

public class UserInputString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = input.next();
        System.out.println("Hello, " + firstName + "!");

        // Consume the rest of the line from the previous input
        input.nextLine(); 

        System.out.print("Enter your full name: ");
        String fullName = input.nextLine();
        System.out.println("Hello, " + fullName + "!");

        input.close();
    }
}
```

-----

### Reading an Integer

To read an integer value from the user, use the `nextInt()` method.

**Code Snippet:**

```java
import java.util.Scanner;

public class UserInputInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = input.nextInt();
        System.out.println("You are " + age + " years old.");
        
        input.close();
    }
}
```

-----

### Reading a Double (Floating-Point Number)

To read a floating-point number from the user, use the `nextDouble()` method.

**Code Snippet:**

```java
import java.util.Scanner;

public class UserInputDouble {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the price: ");
        double price = input.nextDouble();
        System.out.println("The price is: $" + price);
        
        input.close();
    }
}
```

-----

### Reading a Boolean Value

To read a boolean value (`true` or `false`) from the user, use the `nextBoolean()` method.

**Code Snippet:**

```java
import java.util.Scanner;

public class UserInputBoolean {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Is it raining? (true/false): ");
        boolean isRaining = input.nextBoolean();
        System.out.println("It is raining: " + isRaining);

        input.close();
    }
}
```

-----

### Reading Other Data Types

The `Scanner` class also provides methods for other primitive data types:

  * **`nextLong()`**: Reads a `long` value.
  * **`nextFloat()`**: Reads a `float` value.
  * **`nextShort()`**: Reads a `short` value.
  * **`nextByte()`**: Reads a `byte` value.

### Closing the `Scanner`

It's crucial to close the `Scanner` object when you are finished using it to free up system resources. You can do this by calling the `close()` method:

```java
input.close();
```

Failing to close the `Scanner` can lead to resource leaks in your program.