public class University {
    private final int associatedCollege;
    private final String universityName;
    private final int noofCourse;
    private final String[] names;
    public int counter=0;

    {
        universityName = "MIT"; // this is known initializer which is used to intiliazed final varibles
    }

    public University(int associatedCollege, int noofCourse) {
        this.associatedCollege = associatedCollege;
        this.noofCourse = noofCourse;
        this.names = new String[5];
    }

    public void addCourse(String name){
        this.names[counter++] = name;
    }

    public final void displayInfo() {
        System.out.format("Name: %s, No of Collges Associated: %d and No of Courses Offered: %d\n", this.universityName, this.associatedCollege, this.noofCourse);
    }
}
