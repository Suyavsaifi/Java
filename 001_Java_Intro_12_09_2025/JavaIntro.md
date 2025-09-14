# Java Intro

Java is one of the most in-demand programming languages in the world and one of the two official programming languages used for Android development. Although it is a pure object-oriented language, Java has evolved into a multi-paradigm language, making it highly compliant for various situations. Developers who are familiar with Java can create a wide range of applications, games, and tools.

This guide will help you begin your journey with Java and become an accomplished Java developer.

-----

## What is Java?

Java is a high-level, object-oriented, general-purpose programming language that was created by Sun Microsystems (now owned by Oracle) in 1995.

It was designed to be:

* **Platform-independent**: The Java Virtual Machine (JVM) allows Java code to run on any device that has a JVM installed, which is known as “write once, run anywhere”.
* **Robust and secure**: Java has built-in security features and automatically handles memory management.
* **Multithreaded**: It supports concurrent execution, which makes it ideal for performance-heavy applications.
* **Class-based and strongly typed**: The language revolves around classes and objects and has strict type checking.

-----

## Common Usage of Java

* Android app development  
* Enterprise software (logistics, banking, etc.)  
* Web applications (using Spring, JSP)  
* Embedded systems and IoT  
* Game development and scientific computing  

-----

## Architecture of Java

* **JDK** = JRE + Development utilities
* **JRE** = JVM + libraries  

![alt text](https://github.com/Suyavsaifi/Java/blob/main/001_Java_Intro_12_09_2025/images/architecture_of_java.png?raw=true)

-----

## How a Java Program Runs

Java programmers simply write the code, and it runs on the Java Virtual Machine (JVM). 
  
![alt text](https://github.com/Suyavsaifi/Java/blob/main/001_Java_Intro_12_09_2025/images/working_of_program.png?raw=true)

-----

### Java Compiler

The Java compiler takes a **Java Program (.java)** file and converts it into **bytecode (.class)**.

This created `.class` file is then used as input for the JVM.  

![alt text](https://github.com/Suyavsaifi/Java/blob/main/001_Java_Intro_12_09_2025/images/Java_compiler.png?raw=true)

-----

## Properties of Java

* **Statically Typed**: Any variable declared in a Java program must be bound to a specific type of value, and this type cannot change unless it is reassigned.
* **Usually Just-in-Time (JIT) Compiled**: A Java program is first converted into bytecode before it is executed. The JIT compiler then converts the bytecode into machine instructions while the program is being run.
* **Includes a Variety of Libraries**: A "library is a collection of commonly used programming resources".
* **Has a Built-in Garbage Collector**: This process periodically scans the heap memory to identify and clean up unused objects. An unused object is one that is not being referenced by any part of a running program.
* **Has a Number of Related Languages**: Several languages, such as Groovy, Scala, Kotlin, and Clojure, have compilers that translate their source code into JVM bytecode.
