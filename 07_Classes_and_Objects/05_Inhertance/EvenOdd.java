public class EvenOdd {
    public static void main (String[] args){
        // witout using if else condition

        String[] evenOdd = {"Even", "Odd"};

        int number = 1234, index;

        index =  number%2;

        System.out.println("Given number is: " + evenOdd[index]);

    }
}
