public class Car {
    private String brand = "Unknow";
    private String name = "Unknow";

    public Car (String brand, String name){
        this.brand = brand;
        this.name = name;
        System.out.println("Inside Car constructor");
    }


    public void setName(String newName){
        this.name = newName;
    }

    public void getDetails(){
        System.out.format("Brand: %s, name: %s\n", this.brand, this.name);
    }
}
