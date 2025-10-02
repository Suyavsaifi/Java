import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args){

//        do {
//            block of code
//        } while (condition)


        boolean flag = true;

        do {
            System.out.print("Please enter the number: ");
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            String result;
            result = (number%2==0)?"Even":"Odd";
            System.out.println("Given number is "+result);

            System.out.println();
            System.out.println("Do you want to test another number: ");
            Scanner input2 = new Scanner(System.in);
            String feedback = input2.nextLine();
            if (feedback.toUpperCase().trim().equals("NO")){
                flag = false;
                input.close();
                input2.close();
            }

        } while(flag == true);
    }
}

