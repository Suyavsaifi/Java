public class Main {
    public static void main (String[] args){
//        Object obj1 = new Object();
//        Book book1 = new Book();
//
//        System.out.println("Is book1 isntance of Object Class: " + (book1 instanceof Object));

        SciFicBook scifi = new SciFicBook();
        FictionalBook fictionalBook = new FictionalBook();
        Book book = new Book();

        // display binding function
//        System.out.println("Binding Type for SciFi Book: " + scifi.displayBinding());
//        System.out.println("Binding Type for Fictional Book: " + fictionalBook.displayBinding());
//        System.out.println("Binding Type for Book: " + book.displayBinding());

        // Set Binding Type
        scifi.bindingType = "Soft Cover";
        fictionalBook.bindingType = "Hard Cover";

        System.out.println("Binding Type for SciFi Book: " + scifi.displayBinding());
        System.out.println("Binding Type for Fictional Book: " + fictionalBook.displayBinding());
        System.out.println("Binding Type for Book: " + book.displayBinding());

        // calling get book function

        System.out.println("Book Type for SciFi Book: " + scifi.getBook());
        System.out.println("Book Type for Fictional Book: " + fictionalBook.getBook());
        System.out.println("Book Type for Book: " + book.getBook());


        // calling derived class functions from Parent class
        // calling get book function

        System.out.println("Binding Type for SciFi Book: " + ((FictionalBook) book).getFictinalBook());
        System.out.println("Binding Type for Fictional Book: " + ((SciFicBook) book).getSciFiBook());



        Object fictionalObject = new FictionalBook();

        Book fictionalBook2 = new FictionalBook();

        Object scifiObject = new SciFicBook();
        Book scifiBook2 = new SciFicBook();

        SciFicBook bookSciFi = (SciFicBook) new Book();

        FictionalBook bookFictional = (FictionalBook) new Book();


        System.out.println("BookSciFi: " + bookSciFi.getBook());
        System.out.println("Fictional Book: " + bookFictional.getBook());



    }



}
