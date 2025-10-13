import java.util.Objects;

public class Product {

    public int id;
    public String name;
    public String brand;
    public int make;

    public Product(int id, String name, String brand, int make ){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.make = make;

    }

    public void getDetail(){
        System.out.format("Id = %d, Name = %s, Brand = %s and Make = %d", this.id,this.name,this.brand,this.make);
    }

    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }

        if (other == this){
            return true;
        }

        Product product = (Product) other;

        return ((this.id==product.id) && (Objects.equals(this.name, product.name)) && (Objects.equals(this.brand, product.brand)) && (this.make==product.make));
    }
}
