public class carMain {
    public static void main(String[] args){
        Car car = new Car("Global", "Global Name");
        Honda honda = new Honda("Amaze");
        Audi audi = new Audi("X6");

        car.getDetails();
        audi.getDetails();
        honda.getDetails();

        honda.setName("Accord");

        honda.getDetails();
    }
}
