

### **Getting Started with Classes & Objects in Java**



**Course Overview**  
This course provides an introduction to classes and objects, which are core concepts in Java's object-oriented programming (OOP) model. The course explains the relationship between classes and objects, the difference between static and instance variables, and how to instantiate objects.

---

### **Key Features**

**1. Classes and Objects**
* **Class**: A class is an abstract type, conceptualized as a blueprint or template for creating objects. It models a real-world entity by defining its attributes (data) and actions (behavior). In Java, nearly all types, except for a few primitive types, are classes. All classes in Java inherit common properties from a base class known as `java.lang.object`.
* **Object**: An object is an instance of a class. Each object is an independent entity with its own memory on the Java managed heap. The values of its attributes can be updated independently of other objects of the same class. The terms "object" and "instance" are synonymous in Java.

**2. Object-Oriented Programming (OOP) vs. Other Paradigms**
* OOP is a programming paradigm based on the concept of "objects," which can contain both data and code.
* This is contrasted with functional programming, where the basic building block is a function, which is typically stateless. Objects in OOP, on the other hand, are highly stateful.

**3. Class Structure**
* A class encapsulates data and behavior.
    * **Data (State)**: This is contained in member variables, also known as fields.
    * **Behavior (Actions)**: This is defined by methods, which are also known as member functions.

**4. Types of Variables**
* **Instance Variables (Member Variables)**: These are associated with individual objects of a class. Each object has its own independent copy of these variables. They are referred to within the class using the `this` keyword.
* **Static Variables (Class Variables)**: These are associated with the class itself and are shared by all objects of that class. They are declared using the `static` keyword. There is only one copy of a static variable for all instances of a class.

**5. The `this` Keyword**
* The `this` keyword is a special reference used within a class's code to refer to the current object instance itself.

**6. Object Creation (Instantiation)**
* To create an object from a class, you invoke the class's constructor.
* A constructor is a special type of code used to construct an object of a class.
* The process is referred to as instantiating a class or creating an object.
