This document provides an excellent summary of the core concepts in **Object-Oriented Programming (OOP) in Java**, focusing on creating **custom classes and objects** for students.

Here is an informative summary covering the concepts and including all mentioned code.

-----

## 💡 Modeling Entities in Java: Custom Classes and Objects

[cite\_start]Object-Oriented Programming (OOP) in Java relies on creating **custom classes** to model real-world entities, adding to Java's **built-in classes** (like `String`, `Date`, and `Random`)[cite: 1, 14]. [cite\_start]A class defines both **state** (member variables/fields) and **behavior** (methods/functions)[cite: 14]. [cite\_start]An **object** is an instance of a class[cite: 14, 96]. [cite\_start]Every object in Java ultimately inherits from a common base class: `java.lang.Object`[cite: 50, 56, 124].

### 1\. Instantiating and Working with Objects

[cite\_start]Objects are created using the **`new` keyword**, which invokes a special method called the **constructor**[cite: 44, 46, 154].

* **Syntax for Instantiation:**

  ```java
  String someString = new String("Hello String class!");
  Date someDate = new Date(); // Invokes the no-argument constructor
  Random someRandom = new Random();
  ```

* [cite\_start]**Inherent Object Methods:** All objects automatically inherit fundamental methods from `java.lang.Object`[cite: 49, 125, 177]:

    * [cite\_start]`toString()`: Returns a String representation of the object[cite: 51, 80]. [cite\_start]When you pass an object to `System.out.println()`, the `toString()` method is invoked implicitly[cite: 86, 163]. [cite\_start]By default (for most custom objects), it returns the fully qualified class name, followed by `@`, and the object's hexadecimal memory location[cite: 54, 77, 119].
    * [cite\_start]`getClass()`: Returns the object's precise class, which is useful in understanding inheritance and polymorphism[cite: 89, 99].

* **Example Code (Invoking Inherited Methods):**
  This code demonstrates object creation and explicit invocation of inherited methods on a custom `Main` class object:

  ```java
  // 1. Instantiating a custom object (Main is the class containing main method)
  Main main1 = new Main(); 

  // 2. Implicitly calling toString()
  System.out.println("Main 1: " + main1);

  // 3. Explicitly calling toString()
  System.out.println("Main 1 (toString): " + main1.toString()); 

  // 4. Explicitly calling getClass()
  System.out.println("Main 1 (getClass): " + main1.getClass()); 
  ```

-----

## 🧱 Defining Custom Classes and Member Variables

[cite\_start]A custom class, such as `Student`, is defined to hold state (data) and behavior (methods)[cite: 146, 426].

### 2\. Defining a Custom Class and Fields

[cite\_start]Member variables (fields) define the object's **state**[cite: 426].

* **Student.java (Initial Structure with Private Fields):**
  ```java
  package com.skillsoft.classesandobjects;

  public class Student {
      // Member Variables (Fields) - represent the state of a Student object
      private int id;
      private String name;
      private double gpa;
      
      // Constructor and methods will go here
  }
  ```

### 3\. Constructors and the `this` Keyword

[cite\_start]A **constructor** is a method used to create and **initialize** an object's fields[cite: 4, 14, 334].

* [cite\_start]A constructor must have the **same name as the class** and **no return type**[cite: 443, 447].

* [cite\_start]If you define your own constructor, the **default no-argument constructor is removed** by the Java compiler[cite: 329].

* **The `this` Keyword**
  [cite\_start]The `this` keyword is a special reference that always points to the **current object**[cite: 384]. [cite\_start]It is necessary when a parameter name in a method (like a constructor or setter) has the **same name** as a class field to resolve this **name ambiguity**[cite: 380, 438].

* **Student.java (with Constructor using `this`):**

  ```java
  public class Student {
      private int id;
      private String name;
      private double gpa;

      // Three-argument public constructor
      public Student(int id, String name, double gpa) {
          // 'this.id' refers to the class field, 'id' refers to the parameter
          this.id = id; 
          this.name = name;
          this.gpa = gpa;
      }

      // ... other methods
  }
  ```

* **Main.java (Invoking the Constructor):**

  ```java
  // Invokes the three-argument constructor defined above
  Student s1 = new Student(123, "Debbie", 3.5); 
  ```

-----

## 🔒 Access Control and Idiomatic Java

### 4\. Access Modifiers

[cite\_start]**Access modifiers** regulate access to fields and methods from outside the class[cite: 4, 498].

* [cite\_start]**`private`**: A field or method marked `private` **cannot be accessed** from code outside the class where it is defined[cite: 423, 498]. [cite\_start]This enforces **encapsulation** (a key OOP tenet)[cite: 410].
* [cite\_start]**`public`**: A field, method, or constructor marked `public` can be accessed from any other class[cite: 4, 498].
* [cite\_start]**Constructors** can also be marked `private`, which prevents other classes from using the `new` keyword to instantiate objects of that class[cite: 501].

### 5\. Getter and Setter Methods

[cite\_start]To allow controlled access to **private fields** (which is the idiomatic Java practice), you create public **Getter** and **Setter** methods[cite: 5, 550].

* [cite\_start]**Getter (Accessor) Methods:** Used to **retrieve (get)** the value of a private field[cite: 558].

    * **Convention:** Named `getFieldName()` (e.g., `getId()`).
    * **Return Type:** Matches the field type.
    * **Access:** Usually `public`.

* [cite\_start]**Setter (Mutator) Methods:** Used to **update (set)** the value of a private field[cite: 559].

    * **Convention:** Named `setFieldName(dataType fieldName)` (e.g., `setId(int id)`).
    * [cite\_start]**Return Type:** Usually `void`[cite: 561].
    * [cite\_start]**Access:** Usually `public`[cite: 563]. [cite\_start]They must use the **`this` keyword** if the parameter name matches the field name[cite: 557].

* **Student.java (Example Getter/Setter):**

  ```java
  public class Student {
      // ... private fields and public constructor ...
      
      // Getter for ID
      public int getId() {
          return this.id; // Retrieves the value of the 'id' field
      }
      
      // Setter for ID
      public void setId(int id) {
          this.id = id; // Uses 'this' to assign the parameter 'id' to the field 'this.id'
      }
      
      // Getter for Name
      public String getName() {
          return this.name;
      }
      
      // Setter for Name
      public void setName(String name) {
          this.name = name;
      }
      
      // Getter for GPA
      public double getGpa() {
          return this.gpa;
      }
      
      // Setter for GPA
      public void setGpa(double gpa) {
          this.gpa = gpa;
      }
      
      // Custom method to display student information
      public void printStudentInfo() {
          // Note: 'this' is optional here as there is no parameter name conflict
          System.out.println("ID: " + this.id + " Name: " + this.name + " GPA: " + this.gpa); 
      }
  }
  ```

* **Main.java (Using Getters and Setters):**

  ```java
  Student s1 = new Student(123, "Debbie", 3.5); 

  // Print initial state
  s1.printStudentInfo(); // Output: ID: 123 Name: Debbie GPA: 3.5

  // Use a Setter to change the ID
  s1.setId(211);

  // Print new state
  s1.printStudentInfo(); // Output: ID: 211 Name: Debbie GPA: 3.5

  // Instantiate another object
  Student s2 = new Student(223, "Eric", 2.76);
  s2.printStudentInfo(); // Output: ID: 223 Name: Eric GPA: 2.76

  // Use Setters to change multiple fields
  s2.setId(152);
  s2.setName("Oliver");
  s2.printStudentInfo(); // Output: ID: 152 Name: Oliver GPA: 2.76
  ```