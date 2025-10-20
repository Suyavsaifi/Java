public class Main {

    public static void main(String[] args){

        Product car = new Product(101,"X6", "BMW", 2020);

        Product bmw = new Product(101,"X6", "BMW", 2020);

        Product audi = new Product(102, "A8", "Audi", 2019);

        String name1 = "Audi";
        String name2 = "Audi";

        car.getDetail();
        System.out.println();
        bmw.getDetail();
        System.out.println();

//        Product copyCar = car;
//        Product copyBMW = bmw;

        System.out.println("Car: " + car);
//        System.out.println("copyCar: " + copyCar);
        System.out.println("BMW: " + bmw);
//        System.out.println("CopyBMW: " + copyBMW);

//        System.out.println("Is name 1 and name 2 equals: " + name1.equals(name2));
//        System.out.println("Hascode of name 1: " + name1.hashCode());
//        System.out.println("Hascode of name 2: " + name1.hashCode());

        System.out.println("Hascode of car: " + car.hashCode());
        System.out.println("Hascode of bmw: " + bmw.hashCode());
//


//        System.out.println("Is car and bmw equal? " + car.equals(bmw));
//        System.out.println("Is car and audi equal? " + car.equals(audi));
//        System.out.println("Is car and copyCar equal? " + car.equals(copyCar));
//        System.out.println("Is bmw and Copybmw equal? " + bmw.equals(copyBMW));
    }
}
