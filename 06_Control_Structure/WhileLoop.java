import java.util.Scanner;

public class WhileLoop {
    public static void main (String[] args){
        System.out.print("Please enter the number: ");
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();
        long number1 = number;
        input.close();
//        while (num<19){
//            System.out.println("Value of number is "+num);
//            num++;
//        }
        long sum=0, remainder;
        while (number>0){
           remainder = number%10;
           number = number/10;
           sum = sum + remainder;

        }
        System.out.format("Sum of digits of %d is %d.", number1,sum);



    }
}
