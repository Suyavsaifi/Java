class College {
    String college_name = "North Eastern University";
    String name;
    String subject;

    public College(String name, String subject){
        this.name = name;
        this.subject = subject;
    }

    public void getDetail(){
        System.out.format("My name is %s and I have taken %s at %s%n", this.name, this.subject, this.college_name);
    }
}

public class ClassDemo {
    public static void main(String[] args){
        College s1 = new College("Peter", "Physics");
        s1.getDetail();
    }
}