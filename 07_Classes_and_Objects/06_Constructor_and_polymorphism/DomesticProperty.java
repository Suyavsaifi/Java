public class DomesticProperty extends Property {
    String domesticType;
    float Price;
    int size;

    public DomesticProperty(String domesticType, float Price, int size){
        super("Alpha", "Domestic", size);
        this.domesticType = domesticType;
        this.Price = Price;
    }

    public void info(){
        super.info();
        System.out.format("DomesticProperty (Domestic Type: %s, Price: %.2f and Size: %d)\n", this.domesticType, this.Price, this.size);
    }

    public static String displayProperty(){
        return "In domestic property class class";
    }
}
