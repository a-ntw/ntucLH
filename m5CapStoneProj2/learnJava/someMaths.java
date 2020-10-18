/*
Fibonacci Series Program
Factorial Program 
Calculator  Basic Operations for int, double, String [+]
Mathematical Tables 
Exit(0)
 */

public class someMaths {

    public static int F0 = 0;
    public static String dispVal = "";

    public static void main(String args[]) throws Exception {

        int argslen = args.length;

        if (argslen == 2) {
            int num1 = Integer.parseInt(args[1]);
            if ("a".equals(args[0])) {
                Fibonacci(num1);
            } else if ("f".equals(args[0])) {
                Factorial(num1);
            } else if ("x".equals(args[0])) {
                System.exit(0);
            }
        } else if (argslen == 3 && ("t".equals(args[0]))) {
            int num1 = Integer.parseInt(args[1]);
            int num2 = Integer.parseInt(args[2]);
            multiplicationTable(num1, num2);

        } else if ((argslen) > 2 && (argslen) <= 4 && ("c".equals(args[0]))) {
            calculator(args[1], args[2], args[3]);

        } else {
            System.out.println("\n" 
                    + "a n      - Fibonacci Series \n"
                    + "f n      - Factorial Sequence \n"
                    + "c n [] n - Calculator use + - x / \n"
                    + "t n n    - Multiplcation Table row by col \n"
                    + "x 0      - exit(0) \n"
            );
        }
    }

    public static void Fibonacci(int step) {
        /*  Fn = Fn-1 + Fn-2  */
        int Fa = 0;
        int Fb = 1;

        dispVal += "Fibonacci to " + step + ":\n\t" + 0;
        for (int i = 0; i < (step - 2); i++) {
            int Fc = Fb + Fa;
            Fa = Fb;
            Fb = Fc;
            dispVal += "  " + Fc;
        }
        System.out.println(dispVal + "\n");
    }

    public static void Factorial(int Fx) {
        /* 4! = 4 × 3 × 2 × 1 = 24 */
        dispVal = "Factorial of " + Fx + ":\n" + Fx;
        int Fr = Fx;
        while (Fx > 1) {
            Fx = Fx - 1;
            Fr = Fr * Fx;
            dispVal += " x " + Fx;
        }
        System.out.println(dispVal + " = " + Fr + "\n");
    }

    public static void calculator(String a, String b, String c) {

        int n1 = Integer.parseInt(a);
        int n2 = Integer.parseInt(c);

        System.out.printf("calculating ... " + a + " " + b + " " + c + " = ");
        switch (b) {
            case "+":
                System.out.println(n1 + n2);
                break;
            case "-":
                System.out.println(n1 - n2);
                break;
            case "x":
                System.out.println(n1 * n2);
                break;
            case "/":
                float nf1 = Integer.parseInt(a);
                float nf2 = Integer.parseInt(c);
                System.out.println(nf1 / nf2);
                break;
            default:
        }
    }

    public static void multiplicationTable(int row, int col) {
        /*  Multiplication Tables   */
        System.out.println("Multiplication table of " + row + " by " + col);
        for (int j = 1; j <= row; j++) {
            for (int i = 1; i <= col; i++) {
                dispVal += "\t" + (i * j);
            }
            dispVal += "\n";
        }
        System.out.println(dispVal);
    }
}
/* 
antw@Mac-mini cp2Java % javac someMaths.java  
antw@Mac-mini cp2Java % java someMaths        

a n      - Fibonacci Series 
f n      - Factorial Sequence 
c n [] n - Calculator use + - x / 
t n n    - Multiplcation Table row by col 
x 0      - exit(0) 

antw@Mac-mini cp2Java % java someMaths a 13
Fibonacci to 13:
	0  1  2  3  5  8  13  21  34  55  89  144

antw@Mac-mini cp2Java % java someMaths f 5  
Factorial of 5:
5 x 4 x 3 x 2 x 1 = 120

antw@Mac-mini cp2Java % java someMaths c 5 - 3
calculating ... 5 - 3 = 2
antw@Mac-mini cp2Java % java someMaths t 4 4  
Multiplication table of 4 by 4
	1	2	3	4
	2	4	6	8
	3	6	9	12
	4	8	12	16
*/