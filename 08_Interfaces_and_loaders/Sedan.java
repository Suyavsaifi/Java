public class Sedan implements Automobiles, SafetyStandard {
    private String make;
    private String model;
    private Double year;
    private String safetyStandard;

    public Sedan(String make, String model, Double year, String safetyStandard) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.safetyStandard = safetyStandard;
    }

    @Override
    public String get_model() {
        return this.model;
    }

    @Override
    public String get_make() {
        return this.make;
    }

    @Override
    public Double get_year() {
        return this.year;
    }

    @Override
    public String get_safety_standard() {
        return this.safetyStandard;
    }

    @Override
    public String release_date() {
        return "01-01-2014";
    }
}
