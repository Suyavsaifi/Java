public class TernaryOperator {
    public static void main (String[] args){

        int number = 987;

//        if (number%2==0){
//            System.out.println("Given number is even");
//        }
//
//        else{
//            System.out.println("Given number is odd");
//        }

        String output = (number%2==0)?"Even":"Odd";

        System.out.println("Given number is " + output);

    }
}
