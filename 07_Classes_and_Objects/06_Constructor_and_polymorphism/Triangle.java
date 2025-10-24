public class Triangle extends Shape {
    public Triangle(){
        super("Triangle");
    }

    public int getPerimeter(int side1, int side2, int side3){
        return side1+side2+side3;
    }

    @Override
    public void info(){
        System.out.println("My class is triangle and I have 3 sides.");
    }
}
