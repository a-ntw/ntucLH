package savingacc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Saving_CRUB {

    public static Scanner myObj = new Scanner(System.in);
    public static int iteration = 1;

    public static void toContinue() {
        myObj.next();
    }

    public static int DisplayOptions() throws Exception {
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\n ************************************************"
                + "********************************************* ");
        System.out.println("\n\t Saving Account -  CRUD Operations ::: ");
        System.out.println(" \t----------------------------------");
        System.out.println("\n ************************************************"
                + "********************************************* ");

        System.out.println(" \tFollowing are the options :: ");
        System.out.println(" \n\t\t1 >> Create Saving Account ");
        System.out.println(" \n\t\t2 >> List data by Account no. ");
        System.out.println(" \n\t\t3 >> Find Accounts by Cust Name ");
        System.out.println(" \n\t\t9 >> List all accounts details ");
        //System.out.println(" \n\t\t0 >> Exit ");

        System.out.println("\n ************************************************"
                + "********************************************* ");
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
        System.out.println(" =================================================="
                + "============================================================"
                + "================");

    }

    public static void printFooter() {
        System.out.println(" =================================================="
                + "============================================================"
                + "================");
    }

    public static int insAcc() {

        return 0;

    }

    public static int inSAacc() throws Exception {
        int nxtID = SavingAccDao.getNextID();
        System.out.println("\tEnter the following details  :: ");
        //printFooter();
        System.out.println("\n\t\tSA Account ID\t : " + nxtID);
        System.out.print(" \n\t\tAccount No\t : ");
        String accNo = myObj.next();

        double balance = 0;

        System.out.print(" \n\t\tInterest Rate:\t : ");
        double intRate = Double.parseDouble(myObj.next());

        System.out.print(" \n\t\tAccountOpenDate:\t : ");
        String oDate = myObj.next();
        DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate date = LocalDate.parse(dob, sourceFormatter);
        LocalDate accOpenDate = LocalDate.parse(oDate, DateTimeFormatter.ISO_DATE);

        LocalDate accClosedDate = null; // not necessay yet

        System.out.print(" \n\t\tMinimum Balance:\t : ");
        double minBal = Integer.parseInt(myObj.next());
        //int i=Integer.parseInt("200");  

// public SavingAcc(int idSA, String AccNo, double balance, double intRate,
//LocalDate accOpenDate, double minBal) {   
        if (SavingAccDao.insertSAacc(new SavingAcc(nxtID, accNo, balance,
                intRate, accOpenDate, accClosedDate, minBal))) {
            printFooter();
        }
        return 1;

    }

    public static int infoByAccNo() throws Exception {
        printHeader();
        System.out.print(" \tEnter the AccountNo (xxx-xxx-xxx-x):");
        String accNo = myObj.next();

        printHeader();
        System.out.println(
                "ID  \tAccNo \t\tbalance \tintRate \taccOpenDate "
                        + "\taccClosedDate \tminBal");
        SavingAccDao.getInfo(accNo).stream().forEach(System.out::println);
        return 0;

    }

    public static int listAllAcc() throws Exception {
        //printHeader();
        System.out.println(
                "ID  \tAccNo \t\tbalance \tintRate \taccOpenDate "
                        + "\tClosedDate \tminBal");
        //printFooter();
        SavingAccDao.listSA().stream().forEach(System.out::println);

        //printFooter(); 
        return 1;
    }

    public static void Main() throws Exception {
        while (true) {
            int optionVal = DisplayOptions();

            System.out.print("\t\t Option Selected : \t\t");
            switch (optionVal) {

                case 1:
                    System.out.println("Create Account  ");
                    //printFooter();
                    inSAacc();
                    break;

                case 2:
                    System.out.println("List data by Acc No  ");
                    infoByAccNo();
                    break;

                case 9:
                    System.out.println("List all Acc No  ");
                    Saving_CRUB.listAllAcc();
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

    public static void main(String[] args) throws Exception {
        Main();
    }
    
}
