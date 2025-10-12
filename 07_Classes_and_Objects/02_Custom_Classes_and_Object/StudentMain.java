
public class Main {
    public static void main(String[] args) {
//        Main main1 = new Main();
//        System.out.println("Objact 1: " + main1);
//        System.out.println("Class of object 1: " + main1.getClass());
//
//        Main main2 = new Main();
//        System.out.println("Object 2: " + main2);
//        System.out.println("class of object 2: " + main2.getClass());

        Student s1 = new Student(123, "Alex", 11);

        s1.setStd(12);

//        s1.id = 123;
//        s1.name = "Mukhil";
//        s1.std = 12;
//        System.out.println("Id: " + s1.id);
//        System.out.println("Name: " + s1.name);
//        System.out.println("Std: " + s1.std);

        System.out.println(s1.getStudentDetail());

        Student s2 = new Student(150, "Meria", 10);

        System.out.println(s2.getStudentDetail());

        s2.setName("Maria");
        s2.setStd(11);

        System.out.println(s2.getStudentDetail());



        System.out.println("===============================================");

//        s2.id = 150;
//        s2.name = "Maria";
//        s2.std = 10;
//        System.out.println("Id: " + s2.id);
//        System.out.println("Name: " + s2.name);
//        System.out.println("Std: " + s2.std);




//        System.out.println(s1);
//        System.out.println(s1.getClass());

    }
}