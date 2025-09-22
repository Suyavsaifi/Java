public class LogicalOperator {
    public static void main (String[] args){

//        boolean isSunny = true;
//        boolean isWarm = false;

//        System.out.println("isSunny && isWarm " + (isSunny && isWarm)); // o/p - false
//        System.out.println("isSunny || isWarm " + (isSunny || isWarm)); // o/p - true

//        int watchPrice = 500;
//        int Budget = 400;
//        boolean isSale = false;
//        int discount = 150;
//
//        boolean result;
//
//        result = (Budget > watchPrice) || (isSale && (Budget > (watchPrice-discount)));
//
//        System.out.println("Can I buy the watch: " + result);

        // Bitwise operator
        int num1 = 2, num2 = 3;

        System.out.println("2 & 3 = " + (num1 & num2)); // o/p = 2
        System.out.println("2 | 3 = " + (num1 | num2)); // o/p = 3
        System.out.println("2 ^ 3 = " + (num1 ^ num2)); // o/p = 1


    }
}
