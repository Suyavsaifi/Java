public class ArrayType {
    public static void main(String[] args){
        String[] brand = {"JPMC", "SG", "BNY", "GOOGLE"};
        int[] stockPrice = {12,45,90,180};
        System.out.format("Stock Price of %s is %d", brand[0], stockPrice[0]);
        System.out.println();
        System.out.format("Stock Price of %s is %d", brand[1], stockPrice[1]);
        System.out.println();
        System.out.format("Stock Price of %s is %d", brand[2], stockPrice[2]);
        System.out.println();
        System.out.format("Stock Price of %s is %d", brand[3], stockPrice[3]);
        System.out.println();

        // finding the length of array
        System.out.println("Length of array is: "+ stockPrice.length);
    }
}
