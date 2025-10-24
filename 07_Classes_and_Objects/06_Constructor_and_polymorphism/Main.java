public class Main {

    public static void getInfo(Shape shape){
        shape.info();
    }

    public static void main (String[] args){
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();

        getInfo(triangle);
        getInfo(rectangle);
    }
}
