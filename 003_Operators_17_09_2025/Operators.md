### 📚 Java Operators: A Beginner's Guide

This guide will introduce you to the fundamental operators in Java, which are essential for performing calculations, making decisions, and manipulating data.

-----

### What are Operators?

Think of operators as special symbols that perform specific actions on one or more values (called operands). For example, in the expression `5 + 3`, the `+` symbol is the operator, and `5` and `3` are the operands.

-----

### Types of Operators

#### 1\. Arithmetic Operators

These are used for basic mathematical calculations.

| Operator | Name | Example |
| :--- | :--- | :--- |
| `+` | Addition | `10 + 5` results in `15` |
| `-` | Subtraction | `10 - 5` results in `5` |
| `*` | Multiplication | `10 * 5` results in `50` |
| `/` | Division | `10 / 5` results in `2` |
| `%` | Modulus (Remainder) | `10 % 3` results in `1` |

-----

#### 2\. Assignment Operators

These are used to assign a value to a variable.

| Operator | Example | Equivalent To |
| :--- | :--- | :--- |
| `=` | `int x = 10;` | Assigns `10` to `x` |
| `+=` | `x += 5;` | `x = x + 5;` |
| `-=` | `x -= 2;` | `x = x - 2;` |
| `*=` | `x *= 3;` | `x = x * 3;` |
| `/=` | `x /= 2;` | `x = x / 2;` |

-----

#### 3\. Increment (++) and Decrement (--) Operators

These are used to increase or decrease a value by one.

* **Postfix:** The operator comes after the variable (e.g., `x++`). The original value is used in the expression, and then the variable is incremented.
* **Prefix:** The operator comes before the variable (e.g., `++x`). The variable is incremented first, and then the new value is used in the expression.

-----

#### 4\. Comparison Operators

Comparison operators in Java are used to compare two values and determine the relationship between them. They always return a **boolean** value, which is either `true` or `false`. These operators are fundamental to controlling the flow of a program, as they are often used in conditional statements like `if`, `else if`, and `while` loops.

-----

##### Types of Comparison Operators

Java has six main comparison operators:

* **`==` (Equal to):** Checks if the values of two operands are equal.
* **`!=` (Not equal to):** Checks if the values of two operands are not equal.
* **`>` (Greater than):** Checks if the value of the left operand is greater than the value of the right operand.
* **`<` (Less than):** Checks if the value of the left operand is less than the value of the right operand.
* **`>=` (Greater than or equal to):** Checks if the value of the left operand is greater than or equal to the value of the right operand.
* **`<=` (Less than or equal to):** Checks if the value of the left operand is less than or equal to the value of the right operand.

-----

##### Operator Usage and Examples

##### 1\. Equality (`==`) and Inequality (`!=`)

These operators are used to check for equality or inequality between two values.

**Example:**

```java
int a = 10;
int b = 20;

System.out.println(a == b); // false
System.out.println(a != b); // true

String s1 = "hello";
String s2 = "world";
System.out.println(s1 == s2); // false
```

> ⚠️ **Important Note:** When comparing **objects** (like `String`s), the `==` operator checks if the two variables refer to the **same object in memory**, not if their contents are the same. To compare the contents of objects, you should use the `.equals()` method.

-----

##### 2\. Relational Operators (`>`, `<`, `>=`, `<=`)

These operators are used to determine the ordering of two numerical values.

**Example:**

```java
int x = 50;
int y = 50;

System.out.println(x > 40); // true
System.out.println(x < y); // false
System.out.println(x >= y); // true
System.out.println(x <= 30); // false
```

-----

##### Table of Operators

| Operator | Name | Example | Description |
| :--- | :--- | :--- | :--- |
| `==` | Equal to | `a == b` | Returns `true` if `a` and `b` are equal. |
| `!=` | Not equal to | `a != b` | Returns `true` if `a` and `b` are not equal. |
| `>` | Greater than | `a > b` | Returns `true` if `a` is greater than `b`. |
| `<` | Less than | `a < b` | Returns `true` if `a` is less than `b`. |
| `>=` | Greater than or equal to | `a >= b` | Returns `true` if `a` is greater than or equal to `b`. |
| `<=` | Less than or equal to | `a <= b` | Returns `true` if `a` is less than or equal to `b`. |

-----

#### 5\. Logical Operators

These operators are used to combine multiple conditions.

| Operator | Name | Description |
| :--- | :--- | :--- |
| `&&` | Logical AND | Returns `true` if **both** conditions are true. |
| `\|\|` | Logical OR | Returns `true` if **at least one** condition is true. |

-----

### Operator Precedence

Just like in math, operators have a specific order of evaluation called **precedence**. For example, in the expression `2 + 3 * 4`, the multiplication (`*`) is performed before the addition (`+`). You can use parentheses `( )` to change the order of evaluation, just like in a math problem.

-----

### 💻 Code Examples

Here is a Java program that demonstrates many of the operators you've just learned about.

```java
public class OperatorDemo {

    public static void main(String[] args) {
        // Arithmetic Operators
        int a = 20;
        int b = 8;
        System.out.println("a + b = " + (a + b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // Assignment Operators
        int result = 10;
        result += 5; // Same as result = result + 5;
        System.out.println("After result += 5, result is: " + result);

        // Increment and Decrement Operators
        int x = 5;
        System.out.println("Initial x: " + x);
        System.out.println("Value of x++: " + (x++));
        System.out.println("Value of x after postfix increment: " + x);

        int y = 5;
        System.out.println("\nInitial y: " + y);
        System.out.println("Value of ++y: " + (++y));
        System.out.println("Value of y after prefix increment: " + y);

        // Logical Operators
        boolean isSunny = true;
        boolean isWarm = false;
        System.out.println("\nLogical Operators:");
        System.out.println("isSunny && isWarm = " + (isSunny && isWarm));
        System.out.println("isSunny || isWarm = " + (isSunny || isWarm));
    }
}
```