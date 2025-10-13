import java.util.Arrays;

public class ArgumentPassing {

    public static void main(String[] args){

        String[] someArray = {"Apple", "Mango", "Peach", "Guava"};

        System.out.format("Value of number before calling function %s: " , Arrays.toString(someArray)); // 5

        changeValue(someArray);

        System.out.format("Value of number after calling function %s " , Arrays.toString(someArray)); //// 5
        System.out.println();

    }

    public static void changeValue(String[] someArray){
        System.out.println("*************************************************");

        System.out.format("Value of num inside chane Value function before assinging new value %s", Arrays.toString(someArray)); // 5
        System.out.println();
        someArray[0] = "BANANA";
        System.out.format("Value of num inside chane Value function after assinging new value %s ", Arrays.toString(someArray)); //

        System.out.println("**************************************************");
    }

}
