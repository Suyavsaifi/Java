public class Property {
    String projectName;
    String propertyType;
    int propertySize;

    public Property(String projectName, String propertyType, int propertySize){
        this.projectName = projectName;
        this.propertyType = propertyType;
        this.propertySize = propertySize;
    }

    public void info(){
        System.out.format("Property (Project: %s, Type: %s and Size: %d)\n", this.projectName, this.propertyType, this.propertySize);
    }

    public static String displayProperty(){
        return "In property class";
    }
}
