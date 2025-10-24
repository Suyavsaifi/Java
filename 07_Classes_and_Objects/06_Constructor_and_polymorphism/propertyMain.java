public class propertyMain {
    public static void main (String[] args){

//        DomesticProperty domestic = new DomesticProperty("Family House", 2200.0f,1200);
//        Commercial commercial = new Commercial("Office", 250.0f,2400);
//
//        commercial.info();
//        domestic.info();

//        System.out.println(Property.displayProperty());
//        System.out.println(Commercial.displayProperty());
//        System.out.println(DomesticProperty.displayProperty());

//        Property propert = new Property("Alpha", "Demestic", 4200);
//        Commercial commercial = new Commercial("Office Space", 3000, 4200);
//        DomesticProperty domesticProperty = new DomesticProperty("Flats", 3500, 1200);
//
//        System.out.println(propert.displayProperty());
//        System.out.println(commercial.displayProperty());
//        System.out.println(domesticProperty.displayProperty());


        Property propert = new Property("Alpha", "Demestic", 4200);
        Property commercial = new Commercial("Office Space", 3000, 4200);
        Property domesticProperty = new DomesticProperty("Flats", 3500, 1200);

        System.out.println(propert.displayProperty());
        System.out.println(commercial.displayProperty());
        System.out.println(domesticProperty.displayProperty());
    }
}
