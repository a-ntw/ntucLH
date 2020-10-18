
public class javaBasic {

    public static int i = 10;
    public static int j = 10;
    public static int multiplyResult;

    static {
        System.out.println("Adding Numbers " + add(4, 5));
        System.out.println("Adding Numbers " + add("4", "5"));
        System.out.println("Adding Numbers " + add(4.4, 5.2));
        System.out.println("From S1    " + method1(i, j));
                multiplyResult = i * j;
    }

    public static int add(int k, int l) {
        return k + l;
    }

    public static String add(String k, String l) {
        return k + l;
    }

    public static double add(double k, double l) {
        return k + l;
    }

    public static int method1(int k, int l) {
        return k * l;
    }

    public static void m1() {
        System.out.println("Is preloaded \n");
        multiplyResult = i * j;
    }

    public static void main(String[] args) {
        m1();
        System.out.println("Multiply " + multiplyResult);
        String input = System.console().readLine();
        
        int num1 = Integer.parseInt(System.console().readLine());
        int num2 = Integer.parseInt(System.console().readLine());
        System.out.println("Readline " + add(num1, num2));
    }
}
/*
antw@Mac-mini m3w1cp2Java % javac javaBasic.java
antw@Mac-mini m3w1cp2Java % java javaBasic      
Adding Numbers 9
Adding Numbers 45
Adding Numbers 9.600000000000001
From S1    100
Is preloaded 

Multiply 100
antw@Mac-mini m3w1cp2Java % 
 */
