public abstract class Shape {
    private final String shapeType;
    private final int shapeSides;

    public Shape(String shapeType, int shapeSides){
        this.shapeType = shapeType;
        this.shapeSides = shapeSides;
    }

    public abstract double shapeArea();

    public abstract double shapePerimeter();
}
