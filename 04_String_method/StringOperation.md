## String Functions in Java 🚀

Java's `String` class is a **fundamental component** for working with text data. It provides a rich set of methods to manipulate, search, and format strings. Here's a concise guide to some of the most commonly used `String` functions.

-----

### 1\. Creating and Comparing Strings

- **`new String(String s)`**: Creates a **new String object**. Although you can use this, it's more common to use string literals for creating strings.
- **`s1.equals(s2)`**: Compares the **content** of two strings. This is the correct way to check if two strings have the same sequence of characters. `s1 == s2` compares memory addresses, not content.
- **`s1.equalsIgnoreCase(s2)`**: Same as `equals()` but **ignores case**.
- **`s1.compareTo(s2)`**: Lexicographically compares two strings. It returns a **negative, zero, or positive** value depending on whether `s1` is less than, equal to, or greater than `s2`.

<!-- end list -->

```java
String str1 = "Hello";
String str2 = "hello";
System.out.println(str1.equals(str2)); // false
System.out.println(str1.equalsIgnoreCase(str2)); // true
```

-----

### 2\. Searching and Retrieving Information

- **`s.length()`**: Returns the number of characters in the string.
- **`s.charAt(int index)`**: Returns the character at the specified index. Remember that string indices are **zero-based**.
- **`s.indexOf(String sub)`**: Returns the **index** of the first occurrence of the specified substring. Returns **-1** if not found.
- **`s.lastIndexOf(String sub)`**: Returns the index of the **last** occurrence of the substring.
- **`s.contains(String sub)`**: Checks if the string **contains** the specified sequence of characters. Returns a boolean.

<!-- end list -->

```java
String sentence = "The quick brown fox jumps over the lazy dog.";
System.out.println(sentence.length()); // 44
System.out.println(sentence.indexOf("fox")); // 16
System.out.println(sentence.contains("dog")); // true
```

-----

### 3\. Modifying and Manipulating Strings

- **`s.substring(int beginIndex)`**: Returns a new substring from the beginning index to the end of the string.
- **`s.substring(int beginIndex, int endIndex)`**: Returns a new substring from the beginning index to the character **before** the end index.
- **`s.replace(char oldChar, char newChar)`**: Returns a new string with all occurrences of `oldChar` replaced by `newChar`.
- **`s.trim()`**: Returns a new string with leading and trailing **whitespace removed**.
- **`s.toLowerCase()` / `s.toUpperCase()`**: Returns a new string converted to lowercase or uppercase.

<!-- end list -->

```java
String phrase = "  Java is fun!  ";
System.out.println(phrase.trim()); // "Java is fun!"
System.out.println(phrase.toUpperCase()); // "  JAVA IS FUN!  "
```

-----

### 4\. Splitting and Joining Strings

- **`s.split(String regex)`**: Splits the string into an array of substrings based on the provided delimiter (**regular expression**).
- **`String.join(CharSequence delimiter, CharSequence... elements)`**: Joins an array or list of strings into a single string with the specified delimiter.

<!-- end list -->

```java
String names = "Alice,Bob,Charlie";
String[] nameArray = names.split(",");
System.out.println(java.util.Arrays.toString(nameArray)); // [Alice, Bob, Charlie]

String newString = String.join(" ", nameArray);
System.out.println(newString); // Alice Bob Charlie
```