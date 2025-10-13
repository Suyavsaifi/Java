public class Main {

    public static void main(String[] args){

        Product car = new Product(101,"X6", "BMW", 2020);

        Product bmw = new Product(101,"X6", "BMW", 2020);

        car.getDetail();
        System.out.println();
        bmw.getDetail();
        System.out.println();
        System.out.println("Is car and bmw equal? " + car.equals(bmw));
    }
}
