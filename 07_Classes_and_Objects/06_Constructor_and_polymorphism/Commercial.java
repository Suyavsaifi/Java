public class Commercial extends Property{
    String commercialType;
    float rent;
    int size;

    public Commercial(String commercialType, float rent, int size){
        super("Beta", "Commercial", size);
        this.commercialType = commercialType;
        this.rent = rent;
    }


        public void info(){
            super.info();
            System.out.format("Commercial (Type: %s, Rent: %.2f and Size: %d)\n", this.commercialType, this.rent, this.size);
        }

}
