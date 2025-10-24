public class propertyMain {
    public static void main (String[] args){

        DomesticProperty domestic = new DomesticProperty("Family House", 2200.0f,1200);
        Commercial commercial = new Commercial("Office", 250.0f,2400);

        commercial.info();
        domestic.info();
    }
}
