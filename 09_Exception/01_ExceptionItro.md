### Java Exceptions — Overview and Teaching Guide

This lesson explains what exceptions are, how Java implements them, and how to handle them in code. Use the examples below in class to demonstrate behavior, compiler vs runtime differences, the exception hierarchy, stack traces, and good handling patterns.

---

### Key concepts

- **Exception**: An event at runtime that disrupts normal program flow. Java signals it by throwing an exception object.
- **Checked exception**: Must be declared or handled at compile time (e.g., FileNotFoundException, IOException).
- **Unchecked exception**: Runtime exceptions that the compiler does not force you to handle (subclasses of RuntimeException, e.g., NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException).
- **Error**: Serious problems the application typically should not handle (subclasses of Error, e.g., StackOverflowError, OutOfMemoryError).
- **Throwable**: Root superclass of Error and Exception in Java’s class hierarchy.
- **Stack trace**: Shows the thread, exception type, message, and call stack with file/line locations; used to locate the origin of the exception.

---

### Minimal examples to demonstrate behavior

#### 1) Unchecked exceptions (runtime) — Array index and NullPointer
```java
public class UncheckedExamples {
    public static void main(String[] args) {
        String[] arr = {"one", "two", null, "four"};

        // ArrayIndexOutOfBoundsException
        System.out.println(arr[0]);      // OK
        // System.out.println(arr[4]);   // Uncomment to throw ArrayIndexOutOfBoundsException

        // NullPointerException
        System.out.println(arr[2].toUpperCase()); // Throws NullPointerException
    }
}
```

#### 2) NumberFormatException example
```java
public class NumberFormatExample {
    public static void main(String[] args) {
        String[] values = {"3", "56", "112", "345.34"};
        for (String v : values) {
            int n = Integer.parseInt(v);   // throws NumberFormatException for "345.34"
            System.out.println(n);
        }
    }
}
```

#### 3) ArithmeticException (division by zero)
```java
public class ArithmeticExample {
    public static void main(String[] args) {
        int numerator = 100;
        for (int denom = 5; denom >= 0; denom--) {
            System.out.println(numerator / denom); // denominator 0 triggers ArithmeticException
        }
    }
}
```

#### 4) Checked exception example — File reading with try-catch
```java
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedExample {
    public static void main(String[] args) {
        String path = "data/samplefile.txt"; // likely missing
        try {
            FileReader fr = new FileReader(path);
            // read from file (omitted for brevity)
            fr.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found: " + path);
            fnf.printStackTrace();
        } catch (IOException io) {
            System.out.println("I/O error while closing file");
        }
        System.out.println("Program continues after exception handling");
    }
}
```

#### 5) throws declaration vs try-catch
```java
import java.io.FileReader;
import java.io.FileNotFoundException;

public class ThrowsExample {
    // Delegates responsibility to caller / JVM
    public static void openFile(String path) throws FileNotFoundException {
        FileReader fr = new FileReader(path);
        // ...
    }

    public static void main(String[] args) {
        try {
            openFile("data/samplefile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught in main: file missing");
        }
    }
}
```

#### 6) finally and try-with-resources
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinallyExample {
    public static void main(String[] args) {
        // try-with-resources (preferred for AutoCloseable)
        try (BufferedReader br = new BufferedReader(new FileReader("data/samplefile.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("I/O error");
        } finally {
            System.out.println("Finally always executes");
        }
    }
}
```

### Summary
- Compile-time errors prevent the program from building; exceptions occur at runtime and disrupt execution.
- Checked exceptions must be handled or declared; unchecked exceptions need not be declared but should be anticipated.
- Use try-catch, finally, throws, and try-with-resources appropriately.
- Teach students to read stack traces and prefer precise exception handling and resource safety.

---