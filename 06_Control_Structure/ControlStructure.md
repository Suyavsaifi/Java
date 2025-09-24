# Control Structures in Java

Control structures in Java are statements that control the flow of execution in a program. They allow you to make decisions, repeat actions, and branch your code. The main types of control structures are: **sequential**, **selection (decision-making)**, and **iteration (looping)**.

-----

## Sequential Control

This is the most basic control structure. Statements are executed one after the other in the order they appear in the code. Java programs, by default, follow this flow.

```java
public class SequentialDemo {
    public static void main(String[] args) {
        // These statements execute one after the other.
        int number1 = 5;
        int number2 = 10;
        int result = number1 * number2;
        System.out.println("The product is: " + result);
    }
}
```

-----

## Selection (Decision-Making) Structures

These structures allow your program to make decisions and execute specific blocks of code based on a condition.

### `if-else if-else` Statement

This is used for multiple conditions. It checks conditions sequentially and executes the code block for the first `true` condition.

```java
import java.util.Scanner;

public class IfElseDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your exam score: ");
        int score = scanner.nextInt();

        if (score >= 90) {
            System.out.println("You got an A! Excellent work.");
        } else if (score >= 80) {
            System.out.println("You got a B! Great job.");
        } else if (score >= 70) {
            System.out.println("You got a C. Good effort.");
        } else {
            System.out.println("You need to study more for the next exam.");
        }
        scanner.close();
    }
}
```

### `switch` Statement

The `switch` statement is a more efficient way to handle multiple conditions based on the value of a single variable.

```java
import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a day number (1-7): ");
        int day = scanner.nextInt();
        String dayName;

        switch (day) {
            case 1:
                dayName = "Sunday";
                break;
            case 2:
                dayName = "Monday";
                break;
            case 3:
                dayName = "Tuesday";
                break;
            case 4:
                dayName = "Wednesday";
                break;
            case 5:
                dayName = "Thursday";
                break;
            case 6:
                dayName = "Friday";
                break;
            case 7:
                dayName = "Saturday";
                break;
            default:
                dayName = "Invalid day number.";
        }
        System.out.println("The day is: " + dayName);
        scanner.close();
    }
}
```

-----

## Iteration (Looping) Structures

These structures allow a block of code to be executed repeatedly as long as a certain condition is met.

### `for` Loop

A `for` loop is used when you know in advance how many times you want to loop.

```java
public class ForLoopDemo {
    public static void main(String[] args) {
        System.out.println("Counting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count is: " + i);
        }
    }
}
```

### `for-each` Loop (Enhanced `for` Loop)

This loop is used to iterate through elements of arrays and collections. It simplifies the code by eliminating the need for a counter.

```java
public class ForEachLoopDemo {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Cherry"};
        System.out.println("Iterating through the fruits array:");
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}
```

### `while` Loop

A `while` loop executes a block of code as long as a condition is `true`. The condition is checked at the **beginning** of each iteration.

```java
public class WhileLoopDemo {
    public static void main(String[] args) {
        int count = 0;
        System.out.println("While loop counting to 3:");
        while (count < 3) {
            System.out.println("Count is: " + count);
            count++; // Important to increment to avoid an infinite loop
        }
    }
}
```

### `do-while` Loop

A `do-while` loop is similar to a `while` loop, but the condition is checked at the **end** of the loop. This guarantees the code block is executed at least once.

```java
import java.util.Scanner;

public class DoWhileLoopDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        
        System.out.println("Do-while loop: Enter a number greater than 10 to exit.");
        do {
            System.out.print("Enter a number: ");
            input = scanner.nextInt();
        } while (input <= 10);
        
        System.out.println("You entered " + input + ", which is greater than 10. Exiting loop.");
        scanner.close();
    }
}
```

-----

## Branching Statements

These statements change the normal flow of a loop.

### `break`

The `break` statement immediately exits the innermost loop or `switch` statement.

```java
public class BreakDemo {
    public static void main(String[] args) {
        System.out.println("Using 'break' to stop a loop at 4:");
        for (int i = 1; i <= 10; i++) {
            if (i == 4) {
                System.out.println("Breaking the loop at 4!");
                break; // Exit the loop
            }
            System.out.println("Current number: " + i);
        }
    }
}
```

### `continue`

The `continue` statement skips the rest of the current iteration of a loop and moves to the next iteration.

```java
public class ContinueDemo {
    public static void main(String[] args) {
        System.out.println("Using 'continue' to skip printing the number 5:");
        for (int i = 1; i <= 7; i++) {
            if (i == 5) {
                System.out.println("Skipping the number 5...");
                continue; // Skip the rest of this iteration
            }
            System.out.println("Current number: " + i);
        }
    }
}
```