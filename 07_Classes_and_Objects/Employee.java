public class Employee {
    public int id;
    public String name;
    public double salary;
    public String dept;

    public Employee(){
        this.id = 10;
        this.name = "Not Assigned";
        this.salary =0;
        this.dept = "NO DEPT";

    }

    public Employee(int id){
        this.id = id;

    }

    public Employee(int id, String name){
        this(id);
        this.name = name;

    }

    public Employee(int id, String name, double salary){
        this(id, name);
        this.salary =salary;

    }

    public Employee(int id, String name, double salary, String dept){
        this(id, name, salary);
        this.dept = dept;

    }

    public void displayInfo(){
        System.out.format("Id: %d Name: %s Salary: %.2f, Dept: %s", this.id, this.name, this.salary, this.dept);
    }

    public void setParam(int newId){
        this.id = newId;
    }

    public void setParam (int newId, String newName){
        this.setParam(newId);
        this.name = newName;
    }

    public void setParam (int newId, String newName, double newSalary){
        this.setParam(newId, newName);
        this.salary = newSalary;
    }

    public void setParam (int newId, String newName, double newSalary, String newDept){
        this.setParam(newId, newName, newSalary);
        this.dept = newDept;
    }

//    public int showSingleParam(int id) {
//        return id;
//    }
//
//    public double showSingleParam (double id){
//        return id;
//    }
}
