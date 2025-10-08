public class Main {
    public static void main(String[] args){

        Employee emp1 = new Employee(101,"Alice", 65000, "IT");
        System.out.println("\nData before updating");
        emp1.displayInfo();
        System.out.println("\nData after updating");
        emp1.setParam(104, "Alice John");
        emp1.displayInfo();


        Employee emp2 = new Employee(111,"Alex");
        System.out.println("\nData before updating");
        emp2.displayInfo();
        System.out.println("\nData after updating");
        emp2.setParam(112, "Alex", 62000, "ADMIN");
        emp2.displayInfo();


    }

}
