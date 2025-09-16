import javax.swing.plaf.synth.SynthTextAreaUI;

public class NumberDataType {
//    public static void main(String[] args){
//        int varNum = 214876345;
//        int newVarNum = 214_876_345;
//        System.out.println(varNum);
//        System.out.println(newVarNum);
//    }

//    public static void main(String[] args){
////        int varNum = 214_876_3456; // this will result in error as int number is too large
//        long varNum = 214_876_3456L;
//        System.out.println(varNum);
//    }
    public static void main (String[] args){
//        float varNum = 3.14f;
//        double newVarNum = 9.80d;

        float massEarth = 10e3f; // writing number in exponent form
        double antMass = 10E-4d;
        System.out.println("Mass of earth: " + massEarth);
        System.out.println("Weight of ant: " + antMass);
    }
}
