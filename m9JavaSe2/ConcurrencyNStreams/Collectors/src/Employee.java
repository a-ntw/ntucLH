
public class Employee {

    private String lName;
    private String fName;
    private String dept;
    private int salary;
    private String desig;
    private double yoe;

    public Employee(String lName, String fName, String dept, int salary, String desig, double yoe) {
        this.lName = lName;
        this.fName = fName;
        this.dept = dept;
        this.salary = salary;
        this.desig = desig;
        this.yoe = yoe;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public double getYoe() {
        return yoe;
    }

    public void setYoe(double yoe) {
        this.yoe = yoe;
    }

    
    @Override 
    public String toString(){
        return fName + " " + lName +  " " + dept + " " + salary + " " + desig + " " + yoe ;
    }
}
