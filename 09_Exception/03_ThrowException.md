# Throwing Exceptions in Java 

## Overview
- **Goal:** Teach students how to proactively throw exceptions, declare thrown exceptions, handle multiple exceptions across a call stack, translate one exception into another, and define custom exceptions and errors.
- **Why it matters:** Libraries and APIs should signal invalid state or misuse precisely so consumers can handle problems correctly. Throwing the right exception improves clarity, debugging, and API ergonomics.

---

## Key concepts and definitions
- **throw (keyword):** Instantiates and throws a specific Throwable (usually an Exception or Error) at runtime: `throw new IllegalArgumentException("...");`.
- **throws (method signature):** Declares that a method may propagate checked exceptions to its caller: `void foo() throws IOException`.
- **Checked vs Unchecked:**
  - *Checked exceptions* (subclasses of Exception but not RuntimeException) must be declared or caught.
  - *Unchecked exceptions* (RuntimeException and its subclasses, plus Errors) need not be declared.
- **Chaining (cause):** One exception can reference another as its cause: `e.initCause(cause)` or `new Exception(msg, cause)`.
- **Custom exceptions:** Create domain-specific exception classes by extending `Exception` or `RuntimeException`.
- **Errors:** Represent unrecoverable problems (subclasses of `Error`) that typically should terminate the application.

---

## 1) Throwing proactively (simple validation)
- **Defination** Use `throw` to signal invalid arguments/state instead of only printing messages.
- **When to use:** API argument validation, preconditions, or when you want consumers to decide handling.

Java example:
```java
import java.util.Scanner;

public class ThrowExceptions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter GPA: ");
        float gpa = input.nextFloat();
        input.close();

        validateGPA(gpa);
        System.out.println("Processing eligibility...");
    }

    static void validateGPA(float gpa) {
        if (gpa >= 0.0f && gpa <= 4.33f) {
            System.out.println("That is a valid GPA.");
        } else {
            throw new IllegalArgumentException("A GPA must have a value between 0 and 4.33.");
        }
    }
}
```

---

## 2) Throwing multiple exceptions from a method
- **Defination:** A single method can declare multiple exceptions; callers can catch them individually.
- **When to use:** Different failure modes should be signaled with distinct exception types.

Java example:
```java
import java.util.Scanner;
import javax.naming.InvalidNameException;

public class MultipleExceptions {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String uname = sc.nextLine();
        System.out.print("Enter GPA: ");
        float gpa = sc.nextFloat();
        sc.close();

        validateStudent(uname, gpa); // may throw InvalidNameException or IllegalArgumentException
    }

    static void validateStudent(String userId, float gpa) throws InvalidNameException, IllegalArgumentException {
        if (!userId.startsWith("java_")) {
            throw new InvalidNameException("The username is not in the correct format.");
        }
        if (gpa < 0.0f || gpa > 4.33f) {
            throw new IllegalArgumentException("A GPA must be between 0 and 4.33.");
        }
    }
}
```

---

## 3) Chaining exceptions across the call stack (handling at different levels)
- **Defination:** Exceptions propagate up the call stack until handled; handlers can be placed at any call-stack level.
- **Example flow:** validateStudent -> intermediateFunction -> main; handle in intermediateFunction or main.

Java example (handler in main):
```java
import java.util.Scanner;
import javax.naming.InvalidNameException;

public class ChainingExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String uname = sc.nextLine();
        System.out.print("Enter GPA: ");
        float gpa = sc.nextFloat();
        sc.close();

        try {
            intermediateFunction(uname, gpa);
        } catch (InvalidNameException ine) {
            System.out.println("Caught InvalidNameException in main: " + ine.getMessage());
            ine.printStackTrace();
        } catch (IllegalArgumentException iae) {
            System.out.println("Caught IllegalArgumentException in main: " + iae.getMessage());
            iae.printStackTrace();
        }
        System.out.println("Program continues gracefully.");
    }

    static void intermediateFunction(String u, float g) throws InvalidNameException, IllegalArgumentException {
        validateStudent(u, g);
    }

    static void validateStudent(String userId, float gpa) throws InvalidNameException {
        if (!userId.startsWith("java_")) {
            throw new InvalidNameException("Invalid username format.");
        }
        if (gpa < 0 || gpa > 4.33f) {
            throw new IllegalArgumentException("Invalid GPA.");
        }
    }
}
```

---

## 4) Catching one exception and throwing another (exception mapping) and using causes
- **Defination:** Translate low-level exceptions into higher-level, more meaningful exceptions for API consumers; attach the original as the cause for debugging.
- **Why:** Hides implementation details, provides clearer API semantics.

Java example:
```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class MapExceptionExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String uname = sc.nextLine();

        float gpa = 0f;
        try {
            System.out.print("Enter GPA: ");
            gpa = sc.nextFloat();
        } catch (InputMismatchException ime) {
            IllegalArgumentException iae = new IllegalArgumentException("A GPA must be a numeric value between 0 and 4.33.");
            iae.initCause(ime); // chain the original cause
            throw iae; // rethrow a clearer exception for consumers
        } finally {
            sc.close();
        }

        // proceed with validated numeric gpa...
        System.out.println("Received numeric GPA: " + gpa);
    }
}
```

---

## 5) Custom exceptions and throwing Errors
- **Teaching point:** Create domain-specific exceptions by extending `RuntimeException` or `Exception`. Use `Error` for unrecoverable conditions (rare).
- **When to extend RuntimeException:** When the error represents programmer misuse (unchecked).
- **When to extend Exception:** When you want callers to be forced to handle or declare (checked).

Custom exception example (unchecked) and usage:
```java
// InvalidUsernameException.java
public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException(String message) {
        super(message);
        this.initCause(new RuntimeException("The username must begin with java_"));
    }
}
```

```java
// CustomExceptionUsage.java
public class CustomExceptionUsage {
    public static void main(String[] args) {
        userRequest("sam_java", "login"); // will throw InvalidUsernameException
    }

    static void userRequest(String userId, String operation) {
        if (!userId.startsWith("java_")) {
            throw new InvalidUsernameException("The username is not in the correct format");
        }
        System.out.println("User: " + userId + ", Operation: " + operation);
    }
}
```

Throwing an Error example (use sparingly):
```java
static void userRequestWithPermission(String userId, String operation) {
    if (("delete".equals(operation) || "edit".equals(operation)) && !userId.startsWith("java_admin")) {
        throw new IllegalAccessError("The user does not have the required permissions.");
    }
}
```