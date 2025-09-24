import java.util.Scanner;

public class UserInput {
    public static void main(String[] args){
        System.out.print("Please enter your age: ");
        Scanner input = new Scanner(System.in);

//        String name = input.nextLine();
        int age = input.nextInt();
        input.close();
//        System.out.format("My name is %s", name);
        System.out.format("My age is %d", age);

    }
}
