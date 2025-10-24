public class MainShape {
    public static void main (String[] args){
//        Shape obj = new Shape("Shape", 0);

        Circle circle = new  Circle(5);

        System.out.println("Area: " + circle.shapeArea());
        System.out.println("Perimeter: " + circle.shapePerimeter());

    }
}
