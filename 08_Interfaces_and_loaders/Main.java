public class Main {
    public static void main(String[] args) {
        Sedan sedan = new Sedan("Audi", "X7", 2014d, "Europian Saferty Standard");

        System.out.println("Make: " + sedan.get_make());
        System.out.println("Model: " + sedan.get_model());
        System.out.println("Year: " + sedan.get_year());
        System.out.println("Year: " + sedan.get_safety_standard());

        System.out.println("Release Date: " + sedan.release_date());
        System.out.println("Release Date: " + Automobiles.getReleaseDate());

//        Automobiles.safetyStandard = "Europian Safety Standard";

//        System.out.println("Safety Standard: " + Automobiles.safetyStandard);

    }
}
