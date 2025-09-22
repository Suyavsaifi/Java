public class StringOperation {
    public static void main (String[] args){
        String str1 = "JAVA";
        String str2 = "Python";
        String str3 = "java";
        String str4 = "                 Kotlin           ";

        // Concatination
        System.out.println("Concatinatio: " + (str1 + " " + str2));

        // Eqauls - this method check if two string are equal and return true/false
        // it is case sensitive
        System.out.println("Is Java and Python are eqial: " + str1.equals(str2));
        System.out.println("Is Java and java are eqial: " + str1.equals(str3)); // case sensitive

        // Coverting the string to Upper Case or Lower;
        System.out.println("Upper case of java is = " + str3.toUpperCase());
        System.out.println("Lower case of JAVA is = " + str1.toLowerCase());

        // length of string
        System.out.println("Length of Python is = " + str2.length());

        // removing preceding and following space from string
        System.out.println("Kotlin with Space: " + str4);
        System.out.println("Kotlin without Space: " + str4.trim());

    }
}
