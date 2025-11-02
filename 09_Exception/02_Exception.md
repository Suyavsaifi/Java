### Java Exception Handling

---

### Learning objectives
- Define exception, error, checked vs unchecked exceptions
- Read an exception stack trace and locate the failing line
- Implement try-catch, multiple catch handlers, finally, throws, and try-with-resources
- Follow simple best practices for exception handling and resource cleanup

---

### Core concepts
- **Exception**: runtime event that disrupts normal flow; thrown as an object (subclass of java.lang.Throwable).
- **Checked exception**: must be declared or handled at compile time (e.g., FileNotFoundException, IOException).
- **Unchecked exception**: RuntimeException and subclasses; compiler doesn’t force handling (e.g., NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException).
- **Error**: severe problems you generally do not handle (subclasses of Error).
- **Stack trace**: shows thread, exception type, message, and call stack (class/file/line) — use it to find the origin of the failure.
- **Principle**: prefer validating inputs and using specific catches; use generic catch(Exception) only as a last resort for logging/fallback.

---

1) Unchecked exceptions — ArrayIndexOutOfBounds and NullPointerException
```java
public class UncheckedExamples {
    public static void main(String[] args) {
        String[] arr = {"one", "two", null, "four"};
        System.out.println("Start");
        // Runtime exception: uncomment to observe ArrayIndexOutOfBoundsException
        // System.out.println(arr[4]);
        // NullPointerException
        try {
            System.out.println(arr[2].toUpperCase());
        } catch (NullPointerException npe) {
            System.out.println("Caught NPE: element was null");
        }
        System.out.println("End");
    }
}
```

2) NumberFormatException example with graceful skip
```java
public class ParseSafe {
    public static void main(String[] args) {
        String[] values = {"3", "56", "112", "345.34", "18"};
        for (String v : values) {
            try {
                int n = Integer.parseInt(v);
                System.out.println("Parsed: " + n);
            } catch (NumberFormatException nfe) {
                System.out.println("Skipping invalid int: " + v);
            }
        }
        System.out.println("Finished parsing");
    }
}
```

3) ArithmeticException (division by zero) — demonstrate stack trace
```java
public class ArithmeticExample {
    public static void main(String[] args) {
        int numerator = 100;
        for (int denom = 5; denom >= 0; denom--) {
            try {
                System.out.printf("%d / %d = %d%n", numerator, denom, numerator / denom);
            } catch (ArithmeticException ae) {
                System.out.println("Caught ArithmeticException: " + ae.getMessage());
                ae.printStackTrace();
            }
        }
    }
}
```

4) Checked exception — FileReader with try-catch
```java
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedExample {
    public static void main(String[] args) {
        String path = "data/samplefile.txt"; // adjust path
        try (FileReader fr = new FileReader(path)) {
            System.out.println("File opened successfully");
            // read logic omitted for brevity
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found: " + path);
        } catch (IOException io) {
            System.out.println("I/O error: " + io.getMessage());
        }
        System.out.println("Program continues");
    }
}
```

5) throws vs catch — delegate or handle
```java
import java.io.FileReader;
import java.io.IOException;

public class ThrowsExample {
    public static void openFile(String path) throws IOException {
        try (FileReader fr = new FileReader(path)) {
            // read...
        }
    }
    public static void main(String[] args) {
        try {
            openFile("data/samplefile.txt");
        } catch (IOException e) {
            System.out.println("Handled in main: " + e.getMessage());
        }
    }
}
```

6) finally vs try-with-resources
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinallyVsTryWithResources {
    public static void oldStyle() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data/myFile.txt"));
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("I/O: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }

    public static void modernStyle() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/myFile.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("I/O: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        oldStyle();
        modernStyle();
    }
}
```

7) Multiple catch blocks and multi-catch (Java 7+)
```java
public class MultipleCatches {
    public static void main(String[] args) {
        String[] products = {"Power Bank", "USB Cable", null};
        int index = 10;
        try {
            System.out.println(products[index]); // may throw ArrayIndexOutOfBoundsException
            System.out.println(products[products.length - 1].equalsIgnoreCase("mouse")); // may throw NPE
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            System.out.println("Handled specific: " + ex.getClass().getSimpleName());
        } catch (Exception ex) {
            System.out.println("Generic handler: " + ex.getClass());
        }
        System.out.println("Done");
    }
}
```
---

### Quick summary
- Compile-time errors stop compilation; exceptions occur at runtime.
- Checked exceptions must be handled or declared; unchecked exceptions are the programmer’s responsibility to anticipate.
- Use try-catch-finally and try-with-resources to recover and to guarantee cleanup.
- Read stack traces to find the root cause and teach students to prefer specific handlers and input validation.