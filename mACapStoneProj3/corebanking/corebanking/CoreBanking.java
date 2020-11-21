
package corebanking;

import custinfo.Cust_CRUB;
import savingacc.Saving_CRUB;
import java.util.Scanner;


public class CoreBanking {

    public static Scanner myObj = new Scanner(System.in);
    public static int iteration = 1;

    public static void toContinue() {
        myObj.next();
    }

    public static int DisplayOptions() throws Exception {
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\n ********************************************************************************************* ");
        System.out.println("\n\t Customer CRUD Operations menu ::: ");
        System.out.println(" \t----------------------------------");
        System.out.println("\n ********************************************************************************************* ");

        System.out.println(" \tFollowing are the options :: ");
        System.out.println(" \n\t\t1 >> Customer ");

        System.out.println(" \n\t\t2 >> Saving Account ");

        System.out.println(" \n\t\t0 >> Exit ");

        System.out.println("\n ********************************************************************************************* ");
        // Create a Scanner object
        System.out.print(" Enter a numer to carry out the operation  :   ");
        int optVal;
        try {
            optVal = myObj.nextInt();
        } catch (Exception e) {

            optVal = -1;
        }
        return optVal;
    }

    public static void printHeader() throws Exception {
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println(" ==============================================================================================================================");

    }

    public static void printFooter() {
        System.out.println(" ==============================================================================================================================");
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            int optionVal = DisplayOptions();

            System.out.print("\t\t Option Selected : \t\t");
            switch (optionVal) {

                case 1:
                    System.out.println("Customer Particular  ");
                    //printFooter();
                    Cust_CRUB.Main();
                    break;

                case 2:
                    System.out.println("Saving Account ");
                    //printFooter();
                    Saving_CRUB.Main();
                    break;
                case 0:
                    System.out.println("Exit");
                    printFooter();
                    Thread.sleep(4000);
                    System.exit(0);
                    break;
                default:
                    //printHeader();
                    System.out.println(" \n\n \t\t #### Invalid Option ####");
                    //printFooter();
                    Thread.sleep(4000);
                    break;
            }

            System.out.print(" Press any key to continue.....");
            toContinue();
        }
    }

}
