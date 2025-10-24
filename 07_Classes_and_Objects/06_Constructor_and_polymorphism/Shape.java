public class Shape {
    String shapeType = "Unknow";
    public Shape(String shapeType){
        this.shapeType = shapeType;
    }

    public void info(){
        System.out.println("This is main Shape class");
    }

    public String getShape(){
        return String.format("Shape of the object is: %s", this.shapeType);
    }
}
