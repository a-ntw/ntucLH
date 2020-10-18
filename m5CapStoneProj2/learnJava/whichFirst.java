
public class whichFirst {
    
    static int i = 10; // 10 Static Variable
    
    static {
        System.out.println("static begin var i is " + i);  // 10
        
        int i = 30;
        System.out.println("static end var i is " + i); // 30
    }
       public static void main(String [] args){
           int i = 20; // local vairiable
           System.out.println("main var i is " + i); // 20
          
       }
}
/*
antw@Mac-mini cp2Java % javac whichFirst.java
antw@Mac-mini cp2Java % java whichFirst      
static begin var i is 10
static end var i is 30
main var i is 20
antw@Mac-mini cp2Java % 
*/
