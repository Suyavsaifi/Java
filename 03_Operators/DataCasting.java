public class DataCasting {
    public static void main (String[] args){
        // byte < short < char < int < long < float < double

        // widening casting
//        int sourceInt = 10;
//        float targetFloat = sourceInt;
//        System.out.println(targetFloat);

        // narrowing casting
        float narrowFloat = 10f;
        int narrowInt = (int) narrowFloat;
        System.out.println(narrowInt);
    }
}
