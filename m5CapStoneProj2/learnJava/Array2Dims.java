/*
Compute Sum and Average of Array Elements [ 1 & 2 Dimensions]
Write a Java program to find the common elements between two arrays (string values). 
Write a Java program to find the second largest element in an array
Write a Java program to test the equality of two arrays
Sort an array [ for arrays of different dimensions]
					in a dimension
 */

/**
 *
 * @author antw
 */
public class Array2Dims {

    static int[][] arrayA = {
        {5, 4, 3, 2, 1},
        {5, 2, 3, 4, 1},
        {1, 2, 3, 4, 5}};
    static int[][] arrayB = {
        {20, 19, 18, 17, 16},
        {10, 9, 8, 7, 6},
        {15, 14, 13, 12, 11}
    };

    static int arrayC[][] = new int[3][5];  //5 rows and 5 columns  

    static String priStr = "A quick brown fox jumps over the lazy dog.";

    // Nesting don't go deeper than 7 levels
    // Variable names should be intuitive
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {

        // Performace addition of two matrix array
        System.out.println("Array A:");
        dimArrayPrint(arrayA);
        System.out.println("Array B:");
        dimArrayPrint(arrayB);
        int j = arrayA[1][4] + arrayB[1][4];
        System.out.println("Array A + Array B:");
        int[][] result = matrixAdd(arrayA, arrayB);
        dimArrayPrint(result);

        // SwapEx(); // Swap example
        // Sort the Strings of words in order
        sortArrays(priStr);
        //System.out.println("");
        sortDimArray(arrayB); // error, shown arrayC instead

        // arrayTwoDim(); // add 'throws Exception ' at main to work
        //  car();
    }

    // Sort for 2 dim arrays 
    public static void sortDimArray(int[][] inStr) {
        System.out.println("## Sorting of 2 Dim integer array: ");
        dimArrayPrint(inStr);
        int pW[][] = inStr;
        int temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int k = 0; k <= pW.length - 1; k++) {
                int pWkl = pW[k].length - 1; // row index ..
                for (int i = 0; i < pWkl; i++) {
                    // array swap
                    if (pW[k][i] > pW[k][i + 1]) {
                        temp = pW[k][i + 1];
                        pW[k][i + 1] = pW[k][i];
                        pW[k][i] = temp;
                        sorted = false;
                        dimArrayPrint(pW);  // optional
                    }
                }
                if (k < (pW.length - 1)) {
                    // 1st row last unit pW[0][4] >  next row 1st unit pW[1][0]
                    if (pW[k][pWkl] > pW[k + 1][0]) {
                        temp = pW[k + 1][0];
                        pW[k + 1][0] = pW[k][pWkl];
                        pW[k][pWkl] = temp;
                        sorted = false;
                        dimArrayPrint(pW);  // optional
                    }
                }
            }
        }
        dimArrayPrint(pW); // print to consol
    }

    // Sort for arrays in a dimension
    public static void sortArrays(String priStr) {

        System.out.println("## Sorting of single dim String array: ");
        String pW[] = priStr.split(" ");
        printArray(pW); // print to console

        // compare with first array[0] with array[1], 
        String temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < pW.length - 1; i++) {
                if (pW[i].compareTo(pW[i + 1]) > 0) {
                    temp = pW[i + 1];
                    pW[i + 1] = pW[i];
                    pW[i] = temp;
                    sorted = false;
                }
            }
        }
        printArray(pW); // print to console
    }

    /*  swapped YES  */
    public static void SwapEx() {
        String X = "bc";
        String Y = "bb";
        String temp;
        System.out.println(X + "" + Y);

        if (X.compareTo(Y) > 0) {
            temp = Y;
            Y = X;
            X = temp;
        }
        System.out.println(X + "" + Y);
    }

    /* print array  */
    public static void printArray(String[] pW) {
        for (String arg : pW) {
            System.out.print(arg + ", ");
        }
        System.out.println("");
    }

    // 2 dim Array PrintOut
    public static void dimArrayPrint(int[][] Z) {
        for (int[] outerA : Z) {
            System.out.print("[");
            for (int innerA : outerA) {
                System.out.print(innerA + ",");
            }
            System.out.print("]");
        }
        System.out.println("");
    }

    // Return a  2dim array add togather.  
    public static int[][] matrixAdd(int[][] X, int[][] Y) {
        int result[][] = X;
        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < X[i].length; j++) {
                result[i][j] = X[i][j] + Y[i][j]; // x [row][col]
                //System.out.print(result[i][j] + ",");
            }
        }
        return result;
    }

    // Forloop of array with Thread.Sleep
    public static void arrayTwoDim() throws Exception {
        // TODO code application logic here
        int[][] twoDimen = {{1, 2, 3, 4, 5},
        {1, 2, 3, 4, 5},
        {1, 2, 3, 4, 5}};
        while (true) {
            for (int[] outerA : twoDimen) {
                System.out.print("[");
                for (int innerA : outerA) {
                    System.out.print(innerA + ",");
                }
                System.out.println("]");
            }
            Thread.sleep(10000);
            System.out.println("==========================");
        }
    }

    //"for-each" loop, which is used exclusively to loop through elements in an array:
    public static void car() {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        for (String i : cars) {
            System.out.println(i);
        }
    }

    // Count characters/words in a String
    public static void Count(String inStr) {

    }
}

/* //Sort an ArrayList of Strings:
import java.util.ArrayList;
import java.util.Collections;

public class MyClass { 
  public static void main(String[] args) { 
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    
    Collections.sort(cars);

    for (String i : cars) {
      System.out.println(i);
    }
  } 
} */
