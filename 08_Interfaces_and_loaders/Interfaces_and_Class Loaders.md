### Course Overview

An interface is an abstract contract that defines a set of methods and (since modern Java) may include constants, default methods, and static methods. Interfaces let you define APIs decoupled from concrete implementations. Java allows multiple inheritance of interfaces but not of classes. ClassLoaders are the runtime mechanism that locate and define .class bytecode for the JVM; you can implement a custom ClassLoader to load classes from arbitrary sources.

---

### Interfaces — definitions and key characteristics

- Definition: An interface is a type whose methods are public and abstract by default; it declares behavior without (necessarily) providing implementation.
- Cannot instantiate: You cannot create an object of an interface directly (it’s effectively a pure abstract type).
- Default visibility inside interface: methods declared without access modifiers are implicitly public.
- Methods:
  - Prior to Java 8: interface methods were implicitly public and abstract; no implementations.
  - Since Java 8+: interfaces may contain default methods (instance methods with a default implementation) and static methods.
- Fields in interfaces:
  - Any field declared in an interface is implicitly public, static, and final. It must be initialized at declaration.
  - Attempting to reassign such a field results in a compile-time error.
- Inheritance between interfaces:
  - One interface may extend another using extends; an interface extending another inherits its contract.
  - A class that implements an interface must implement all abstract methods from that interface and any parent interfaces unless the class is declared abstract.

Key points:
- Use implements to implement an interface in a class.
- Use extends when an interface inherits from another interface.
- Variables of interface type are allowed and form the basis of polymorphism.

---

### Implementing interfaces — rules, access and polymorphism

- A class that implements an interface must implement every abstract method declared by the interface (or declare the class abstract).
- Implementations must have public access (you cannot use weaker access: protected, private, or package-private).
- @Override annotation is valid when implementing interface methods (recommended).
- Multiple interfaces: a class may implement multiple interfaces separated by commas (Java supports multiple inheritance of interfaces).
- When two implemented interfaces declare the same method signature (including return type), one implementation in the class suffices.
- If two interfaces declare methods with identical names and parameter lists but different return types, the compiler reports a conflict (return type is part of the signature check in this context).
- Runtime polymorphism:
  - You can store a concrete implementing instance in a variable typed as the interface; calls are limited to that interface’s methods unless you cast.

Example: interface, implementing class, and runtime polymorphism
```java
// Automobile.java
public interface Automobile {
    String getMake();
    String getModel();
    Double getPrice();
    // field in interface (public static final)
    String safetyAssessmentProgram = "Global NCAP";

    // default method (since Java 8)
    default String getReleaseDate() {
        return getFormattedCalendarString();
    }

    static String getFormattedCalendarString() {
        java.util.Calendar now = java.util.Calendar.getInstance();
        return String.format("%d-%d-%d",
            now.get(java.util.Calendar.MONTH),
            now.get(java.util.Calendar.DAY_OF_MONTH),
            now.get(java.util.Calendar.YEAR));
    }
}

// Sedan.java
public class Sedan implements Automobile {
    private String make;
    private String model;
    private Double price;

    public Sedan(String make, String model, Double price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    @Override public String getMake()  { return make; }
    @Override public String getModel() { return model; }
    @Override public Double getPrice() { return price; }

    @Override public String toString() {
        return String.format("Make: %s, Model: %s, Price: %s", make, model, price);
    }
}

// Usage (runtime polymorphism)
Automobile car = new Sedan("Honda", "Civic", 21000.0);
System.out.println(car.getModel());             // works
System.out.println(Automobile.safetyAssessmentProgram); // access interface constant
```

---

### Interface fields, default methods, abstract classes implementing interfaces

- Interface fields are constants (public static final) — access via InterfaceName.FIELD or instance.FIELD (compiler permits both).
- Default methods solve backward-compatibility: adding a new default method to an existing interface avoids breaking existing implementors.
- Interfaces can also define static helpers accessible via InterfaceName.staticMethod().
- Abstract classes may implement an interface partially:
  - An abstract class implementing an interface may implement some methods and declare others abstract.
  - Subclasses of the abstract class must implement remaining abstract methods (even if the interface provided a default implementation — the abstract class can re-declare the method abstract to force subclasses to implement it).

Example: abstract base and child
```java
// ConceptCar.java
public abstract class ConceptCar implements Automobile {
    private String make;
    private String model;

    public ConceptCar(String make, String model) {
        this.make = make; this.model = model;
    }

    @Override public String getMake()  { return make; }
    @Override public String getModel() { return model; }

    // leave price and release date abstract
    @Override public abstract Double getPrice();
    @Override public abstract String getReleaseDate(); // forces subclasses to implement
}

// Sedan extends ConceptCar
public class Sedan extends ConceptCar {
    private Double price;

    public Sedan(String make, String model, Double price) {
        super(make, model); this.price = price;
    }

    @Override public Double getPrice() { return price; }

    @Override public String getReleaseDate() {
        // invoke interface static helper
        return Automobile.getFormattedCalendarString();
    }
}
```

---

### ClassLoaders — role, hierarchy, delegation model

Definitions and use-cases:
- ClassLoader: runtime component responsible for locating and defining classes from .class bytecode and turning them into Class objects used by the JVM.
- Typical use-cases:
  - Loading application classes.
  - Loading classes from external jars at runtime (plugins).
  - Custom class isolation, dynamic reloading, sandboxing and runtime bytecode load.

Hierarchy (parent delegation model):
- Bootstrap ClassLoader
  - Loads core Java classes (rt or java.* core classes). In Java API, getClassLoader() for bootstrap-loaded classes returns null.
- Platform (or extension) ClassLoader
  - Loads non-core platform modules/libraries (e.g., java.sql.* modules). Often visible as PlatformClassLoader.
- Application (or system) ClassLoader
  - Loads application classes from classpath; delegates upstream first.

Delegation rules:
- When asked to load a class, a ClassLoader first delegates to its parent (upwards) to try loading; only if parent cannot load will it attempt itself.
- Consequence: application ClassLoader can successfully load platform classes (via upward delegation). Platform ClassLoader cannot load application-specific classes (it’s above in the hierarchy), so asking platform loader to load an application-only class typically fails.

Observations and practical notes:
- Class.forName(name, initialize, classLoader) delegates and can throw ClassNotFoundException if classloader chain cannot resolve the class.
- You can call classLoader.loadClass(name) directly to exercise the load logic.
- External jars added to application classpath are typically loaded by the application ClassLoader.

---

### Creating and using a custom ClassLoader (FileSystemClassLoader)

Purpose: load .class files from a non-classpath file system location (or arbitrary URL) and define classes from raw byte arrays.

Essential steps:
1. Extend ClassLoader and override findClass(String binaryName).
2. Convert the binaryName (fully qualified name) to a file name (e.g., split by '.' and use the final token as class name) or map to path.
3. Read the .class file bytes into a byte[].
4. Call defineClass(binaryName, classBytes, 0, classBytes.length) to obtain Class<?>.
5. Use reflection on the returned Class object to obtain constructors and instantiate objects.

Complete illustrative implementation (simplified, file-reading and error handling included):
```java
// FileSystemClassLoader.java
package com.skillsoft.reflection;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileSystemClassLoader extends ClassLoader {
    private final String filePath; // directory where .class files are stored, trailing slash

    public FileSystemClassLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected Class<?> findClass(String binaryName) throws ClassNotFoundException {
        try {
            // Extract class simple name from fully qualified binaryName
            String[] nameComponents = binaryName.split("\\.");
            String className = nameComponents[nameComponents.length - 1];
            String fileName = filePath + className + ".class";

            byte[] classBytes = loadClassFromFile(fileName);
            return defineClass(binaryName, classBytes, 0, classBytes.length);
        } catch (FileNotFoundException fnfe) {
            throw new ClassNotFoundException("Class file not found", fnfe);
        } catch (IOException ioe) {
            throw new ClassNotFoundException("IO error reading class file", ioe);
        }
    }

    private byte[] loadClassFromFile(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ByteArrayOutputStream byteStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                byteStream.write(buffer, 0, read);
            }
            return byteStream.toByteArray();
        }
    }
}
```

Using the custom loader and reflection to instantiate loaded classes:
```java
// Main.java (example usage)
import com.skillsoft.reflection.FileSystemClassLoader;
import java.lang.reflect.InvocationTargetException;

public class Main {
    private final static String FILE_PATH = "/path/to/outside_project/"; // directory containing Course.class, Student.class

    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        ClassLoader customClassLoader = new FileSystemClassLoader(FILE_PATH);

        // Load Student class by fully qualified name
        Class<?> studentClass = customClassLoader.loadClass("com.skillsoft.university.Student");
        System.out.println(studentClass); // prints: class com.skillsoft.university.Student

        // Instantiate via reflection: suppose Student constructor is (String name, String university, String major)
        Object student = studentClass
            .getConstructor(String.class, String.class, String.class)
            .newInstance("Janice", "Columbia", "Computer Science");
        System.out.println(student); // uses Student.toString()

        // Load Course class and instantiate similarly
        Class<?> courseClass = customClassLoader.loadClass("com.skillsoft.university.Course");
        Object course = courseClass
            .getConstructor(String.class, String.class)
            .newInstance("Data Structures and Algorithms", "Computer Science");
        System.out.println(course);
    }
}
```

Limitations and caution:
- The simple FileSystemClassLoader shown does not resolve dependencies (other classes, external jars). If the loaded class depends on other application classes or external libraries, you must ensure resolution (e.g., implement custom findClass to delegate appropriately or provide bridge to parent classloaders).
- Security considerations: loading bytecode dynamically should be controlled and validated in production contexts.
- Class identity: classes loaded by different classloaders are distinct even if they come from the same bytecode; beware of ClassCastException when mixing classloader boundaries.