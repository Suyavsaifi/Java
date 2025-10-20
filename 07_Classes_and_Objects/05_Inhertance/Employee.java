public class Employee {

    private String empId;
    private String empName;
    private double baseSalary;

    public Employee(String empId, String empName, Double baseSalary){
        this.empId = empId;
        this.empName = empName;
        this.baseSalary = baseSalary;
    }

    public Employee(){

    }

    public double getBaseSalary(){
        return this.baseSalary;
    }
}
