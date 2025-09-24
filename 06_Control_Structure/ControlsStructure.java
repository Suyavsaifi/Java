import java.util.Scanner;

public class ControlsStructure {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the current temperature in F: ");

        int temp = input.nextInt();
        input.close();

        if (temp>90){
            System.out.println("The weather is hot. Please keep yourself safe from heatwave.");

        }
        else if (temp>70){
            System.out.println("Wheather is sunny.");
        }


        else if (temp>30){
            System.out.println("Weather is cold");
        }
        else{
            System.out.println("Weather is too cold.");
        }

    }
}
