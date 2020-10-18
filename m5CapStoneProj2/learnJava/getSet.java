
public class test {

    private String name; // private = restricted access

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }

    
    private int number;

    public int getNumber() {
        return this.number;
    }
    
    //public void setNumber(int num) {
    //    this.number = num;
    //}
    public void setNumber(int num) {
        if (num < 10 || num > 100) {
            throw new IllegalArgumentException();
        }
        this.number = num;
    }

    
    public static void main(String[] args) {
        test myObj = new test();

        myObj.name = "John";  //  error ?
        System.out.println(myObj.name); //  error ?

        myObj.setName("John"); // Set the value of the name variable to "John"
        System.out.println(myObj.getName());

        
        test obj = new test();
        obj.number = 10;    // ?? compile error, since number is private
        int num = obj.number; // same as above
        System.out.println(num);

        obj.setNumber(10);  // OK
        num = obj.getNumber();  // fine
        System.out.println(num);
    }
}
/*
antw@Mac-mini cp2Java % java test      
John
John
10
10
antw@Mac-mini cp2Java % 
*/