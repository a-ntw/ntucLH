/** 220325
 * learning lambda
 * Reference
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */


import java.util.ArrayList;
import java.util.List;

public class Fruit {

    public enum Sellable {
        YES, NO
    }
    
    Integer age;
    Sellable grade;

    public Integer getDays() {
        return age;
    }

    public Sellable getGrade() {
        return grade;
    }

    public Fruit(Integer age, Sellable grade) {
        this.age = age;
        this.grade = grade;
    }

    public void printRow() {
        System.out.println("Fruit{" + "age=" + age + ", grade=" + grade + '}');
    }

    /*
    public boolean test(Fruit p){
        return p.getGrade() == Fruit.Sellable.YES
                && p.getDays() >= 18 
                && p.getDays() <= 25;
    } */
    
    public static void printFruits(List<Fruit> basket, CheckFruit tester) {
        for (Fruit a : basket) {
            if (tester.test(a)) {
                a.printRow();
            }
        }
    }
    
    public static void main(String[] args) {
        List<Fruit> crate = new ArrayList<>(3);
        
        crate.add(new Fruit(10, Sellable.NO));
        crate.add(new Fruit(15, Sellable.YES));
        crate.add(new Fruit(20, Sellable.YES));
        crate.add(new Fruit(25, Sellable.YES));
        crate.add(new Fruit(30, Sellable.NO));
        
        /*
        System.out.println("====== orint thru CheckFruit");
        printFruits(
            crate,
            new CheckFruit() {
                public boolean test(Fruit p){
                return p.getGrade() == Fruit.Sellable.YES
                        && p.getDays() >= 18 
                        && p.getDays() <= 25;
                }
            }
        ); */
        
        System.out.println("====== using lambda");
        printFruits(
                crate,
                (Fruit p) -> p.getGrade() == Fruit.Sellable.YES
                        && p.getDays() >= 18 
                        && p.getDays() <= 25
        );
    }
    
}

interface CheckFruit {
    boolean test(Fruit f);
}

/** console
====== using lambda
Fruit{age=20, grade=YES}
Fruit{age=25, grade=YES}
 */