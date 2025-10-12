public class Student {
    private int id;
    private String name;
    private int std;

    public Student(int id, String name, int std){
        this.id = id;
        this.name = name;
        this.std = std;
    }

    public String getStudentDetail(){
        return String.valueOf(this.id) + " " + this.name + " " + String.valueOf(this.std);

    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStd(int std){
        this.std = std;
    }
}
