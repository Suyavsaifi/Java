public class Circle extends Shape{
    private final int radius;
    public Circle(int radius){
        super("Circle", 0);
        this.radius = radius;

    }

    public double shapeArea(){
        return 3.14*this.radius*this.radius;
    }

    public double shapePerimeter(){
        return 2*3.14*this.radius;
    }
}
