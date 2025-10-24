### Course Overview

This document teaches Java inheritance, method overriding, method hiding (static methods), the `final` and `abstract` keywords, and the four access modifiers (public, private, protected, package-private). It includes runnable code examples and classroom-friendly explanations with real‑life analogies so students can both understand and demonstrate the concepts.

---

### Class hierarchy and base code

Explanation
- We use a small property-management example: a base class `Property` and two derived classes `ResidentialProperty` and `CommercialProperty`.
- The examples show constructors, fields, enums, overriding, `super`, `toString`, and static methods.
- Copy these classes into a single package `com.skillsoft.inheritanceandinterfaces` and run `Main` to execute.

Code
```java
// package com.skillsoft.inheritanceandinterfaces;

public class Property {
    private String propertyType = "unknown";
    private final String projectName;
    private final int propertySize;

    public Property(String propertyType, String projectName, int propertySize) {
        this.propertyType = propertyType;
        this.projectName = projectName;
        this.propertySize = propertySize;
    }

    public void printDetails() {
        System.out.format("Property {type=%s, projectName=%s, propertySize=%s}",
                propertyType, projectName, propertySize);
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format("Property {type=%s, projectName=%s, propertySize=%s}",
                propertyType, projectName, propertySize);
    }

    // Example static method (used to demonstrate hiding)
    public static String getPropertyType() {
        return "unknown";
    }
}

// ResidentialProperty.java
public class ResidentialProperty extends Property {
    public enum Type { SINGLE_FAMILY_HOME, CONDO, TOWNHOME }

    private Type residentialPropertyType = Type.CONDO;
    private float hoaFees;

    public ResidentialProperty(String projectName, int propertySize, Type residentialPropertyType, float hoaFees) {
        super("Residential", projectName, propertySize);
        this.residentialPropertyType = residentialPropertyType;
        this.hoaFees = hoaFees;
    }

    @Override
    public void printDetails() {
        // Option A: full override
        // System.out.format("ResidentialProperty {type=%s, HOA Fees=%.1f}",
        //         residentialPropertyType, hoaFees);
        // System.out.println();

        // Option B: reuse base behaviour and then add (preferred for reuse)
        super.printDetails();
        System.out.format("ResidentialProperty {type=%s, HOA Fees=%.1f}",
                residentialPropertyType, hoaFees);
        System.out.println();
    }

    @Override
    public String toString() {
        String baseString = super.toString();
        return String.format("%s, %nResidentialProperty {type=%s, HOA Fees=%.1f}",
                baseString, residentialPropertyType, hoaFees);
    }

    public static String getPropertyType() {
        return "Residential";
    }
}

// CommercialProperty.java
public class CommercialProperty extends Property {
    public enum Type { OFFICE, RETAIL, INDUSTRIAL }

    private Type commercialPropertyType = Type.OFFICE;
    private float contractedServicesFees;

    public CommercialProperty(String projectName, int propertySize, Type commercialPropertyType, float contractedServicesFees) {
        super("Commercial", projectName, propertySize);
        this.commercialPropertyType = commercialPropertyType;
        this.contractedServicesFees = contractedServicesFees;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.format("CommercialProperty {type=%s, Contracted Services Fees=%.1f}",
                commercialPropertyType, contractedServicesFees);
        System.out.println();
    }

    @Override
    public String toString() {
        String baseString = super.toString();
        return String.format("%s, %nCommercialProperty {type=%s, Contracted Services Fees=%.1f}",
                baseString, commercialPropertyType, contractedServicesFees);
    }

    public static String getPropertyType() {
        return "Commercial";
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Overriding and toString examples ===");
        ResidentialProperty alpha = new ResidentialProperty("Alpha", 1200, ResidentialProperty.Type.TOWNHOME, 4000);
        ResidentialProperty beta  = new ResidentialProperty("Beta", 900, ResidentialProperty.Type.CONDO, 3000);
        System.out.println(alpha); // uses ResidentialProperty.toString -> includes base + derived
        System.out.println(beta);

        CommercialProperty gamma = new CommercialProperty("Gamma", 3000, CommercialProperty.Type.OFFICE, 7000);
        CommercialProperty delta = new CommercialProperty("Delta", 10000, CommercialProperty.Type.RETAIL, 15000);
        System.out.println(gamma);
        System.out.println(delta);

        Property epsilon = new Property("Plot", "Epsilon", 1600);
        System.out.println(epsilon);
    }
}
```

Real-life analogy
- Base class `Property` is like a basic printed invoice template. Derived classes `ResidentialProperty` and `CommercialProperty` add fields and extra rows specific to the invoice type. Overriding lets derived invoices include base info plus specialized lines.

---

### Overriding, dynamic dispatch, and super()

Key points
- Overriding: a derived class provides a new implementation for a non-static instance method declared in the base class.
- Dynamic method dispatch: Java chooses the runtime object's override (derived implementation) for instance methods even when the compile‑time type is the base type.
- Use `@Override` to catch mistakes; it’s compile-time helpful.
- `super`:
  - In a constructor: `super(...)` must be first statement to call base constructor.
  - In a method: `super.method()` calls base class implementation; use to reuse base behavior.

Example (runtime polymorphism)
```java
Property p = new ResidentialProperty("Alpha", 1200, ResidentialProperty.Type.TOWNHOME, 4000);
p.printDetails(); // runtime: ResidentialProperty.printDetails runs because object is ResidentialProperty
```

Teaching tip
- Show two runs: one where variable type is derived (no polymorphism ambiguity) and one where variable type is base (runtime polymorphism). Both should call derived override.

---

### Static methods, hiding, and why they are "static"

Key points
- Static methods belong to the class, not instances; they are bound at compile time.
- You cannot override static methods—when a derived class defines a static method with same signature, it hides the base method.
- Invocation resolution:
  - Class reference: `Property.getPropertyType()` returns the class’s version.
  - Instance reference: `instance.getPropertyType()` is allowed by Java but *resolved by the compile-time type* of the variable (so it behaves like `CompileTimeType.getPropertyType()`).

Example (hiding)
```java
System.out.println(Property.getPropertyType());            // "unknown"
System.out.println(ResidentialProperty.getPropertyType()); // "Residential"
System.out.println(CommercialProperty.getPropertyType());  // "Commercial"

// Using variables:
Property a = new ResidentialProperty(...);
ResidentialProperty b = new ResidentialProperty(...);

System.out.println(a.getPropertyType()); // resolved as Property.getPropertyType() -> "unknown"
System.out.println(b.getPropertyType()); // resolved as ResidentialProperty.getPropertyType() -> "Residential"
```

Real-life analogy
- Static methods are like library policies posted on the office wall for a specific department: you refer to the department's wall (class), not the particular employee (instance). If a derived department posts a new policy, it hides the base policy for that department — but looking up via Employee ID that’s typed to an earlier department might refer to the older posted policy.

Teaching tip
- Emphasize difference: instance (virtual) methods use runtime type; static methods use compile-time type.

---

### final keyword: fields, methods, classes (with examples)

final fields
- A `final` field can be assigned:
  - At declaration,
  - In an instance initialization block,
  - Or in every constructor.
- After initialization, reassignment is not allowed.
- For arrays: `final String[] arr` prevents reassigning `arr`, but you can change elements `arr[0] = "x"`.

Example
```java
private final long id = Math.round(Math.random() * 100000); // OK
// or:
private final long id;
{ id = Math.round(Math.random() * 100000); } // instance init block
```

final methods
- `public final void doIt()` cannot be overridden in subclasses.

final classes
- `public final class Utility { ... }` cannot be extended.

Class + method example
```java
public class Base {
    public final String toString() { return "can't override me"; }
}
```
Trying to override `toString` in subclass will cause a compile-time error.

Real-life analogy
- `final` is like "sealed" decisions: a final field is an immutable ID number; a final method is a contract you cannot change; a final class is a product model that cannot be customized further.

---

### abstract classes, abstract methods, and access modifiers (public/private/protected/package-private)

Abstract classes and methods
- `abstract class` cannot be instantiated directly; it provides common structure and (optionally) abstract method signatures.
- `abstract` method: declared without body. Any concrete subclass must implement it or itself be declared `abstract`.

Example (phones)
```java
public abstract class Phone {
    private final String operatingSystem;
    private final String brandName;
    private final float basePrice;

    public Phone(String os, String brand, float basePrice) {
        this.operatingSystem = os; this.brandName = brand; this.basePrice = basePrice;
    }

    protected float getBasePrice() { return basePrice; } // accessible to subclasses
    public abstract double computeTotalPrice(); // subclass must implement
}
```
Subclasses (OnePlus, IPhone) implement `computeTotalPrice()` and may call `getBasePrice()`.

Access modifiers (quick reference and classroom examples)
- `public`: accessible from anywhere (across packages).
  - Example: `public String toString()` — everyone can call it.
- `private`: accessible only inside the declaring class.
  - Example: `private long id;` prevents direct external access; used for encapsulation.
- `protected`: accessible in the same package, and in subclasses (even if subclass is in different package).
  - Subclass-only access from a different package is allowed; non-subclass outside package cannot access.
  - Example: `protected float getBasePrice()` — subclasses can use it to compute derived behavior.
- package-private (default, no modifier): accessible only within the same package.
  - Omit modifier: `String propertyType;` -> visible in package, but invisible outside package.

Classroom examples and pitfalls
- Show `protected` subtlety:
  - A class in package A that extends `Property` can access `protected` members even if subclass is in package B.
  - A non-subclass in a different package cannot access `protected` members.
- Demonstrate default/package-private:
  - Members without modifier behave like public inside package, private outside it.

Real-life analogy
- Access modifiers are like office access control:
  - `public` = signboard in the lobby (everyone can see).
  - `private` = locked personal drawer (only the owner can open).
  - `protected` = team-only documents plus team‑leads in other offices (accessible to team or to extensions).
  - package-private = documents visible only to employees in the same office floor.

---

### Teaching exercises and checks (quick list)

1. Run overriding demo:
   - Create derived objects, call overridden method through base-type variable and derived-type variable; confirm runtime dispatch for instance methods.
2. Static hiding exercise:
   - Call `Class.staticMethod()` and then `instance.staticMethod()` where `instance`’s *compile-time* type is a base type; observe compile-time binding.
3. final exercises:
   - Mark a field `final` and try to set it later; show compile-time error.
   - Mark a method `final` and attempt override; show error.
   - Mark class `final` and try to extend; show error.
4. abstract exercises:
   - Create abstract base class with stub abstract method; have a derived concrete class implement it; try instantiating abstract class (error).
5. access modifier checks:
   - Create two packages and attempt accesses to members with `public`, `private`, `protected`, and package-private; verify rules.

---

### Summary (classroom punchlines)

- Overriding: instance-level behavior; dynamic dispatch picks the runtime object's method.
- `super`: reuse base constructors and methods.
- Static methods: not overridden; they are hidden and resolved at compile time based on the compile-time type.
- `final`:
  - fields: single assignment (init in declaration, constructor, or init block),
  - methods: cannot be overridden,
  - classes: cannot be extended.
- `abstract`: classes or methods signal “incomplete” contracts; subclasses must implement abstract methods unless they themselves are abstract.
- Access modifiers control visibility: public > protected/package-private > private (with the `protected` nuance across packages).

Use the provided code as lab exercises: change variable types, add/removes modifiers, and ask students to predict results before running the code.
