public class Rectangle extends Shape {
    public Rectangle(){
        super("Rectangle");

    }

//    public double getArea(double length, int width){
//        System.out.println("Double length and int width");
//        return length*width;
//    }
//
//    public double getArea(int length, double width){
//        System.out.println("int length and double width");
//        return length*width;
//    }

    public int getArea(int length, int width){
        System.out.println("double length and double width");
        return length*width;
    }

    public int getPerimeter(int length, int width){
        return 2*(length+width);
    }

    @Override
    public void info(){
        System.out.println("My class is rectange and I have 4 sides. My opposite sides are equal.");
    }
}
