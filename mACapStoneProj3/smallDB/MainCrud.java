package smallDB;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainCrud {

    public static Scanner myObj = new Scanner(System.in);
    //myObj.useDelimiter("\n");
    public static int iteration = 1;

    public static void toContinue() {
        myObj.next();
    }

//    public static String printPretty() {
//        String s = "\n  |";
//        for (int i = 0; i <= iteration; i++) {
//            s += "---";
//        }
//
//        return s + " >> ";
//    }
    public static int listCust() throws Exception {
        //printHeader();
        System.out.println("ID \tName \t\tAddress \t\tAge");
        //printFooter();
        Dao.listCust().stream().forEach(System.out::println);
        //printFooter();
        return 1;
    }

    public static int insCust() throws Exception {
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//
        //int nxtID = Dao.getNextID();      
        System.out.println(" \tEnter the following details  :: ");
        //printFooter();
        //System.out.println(" \n\t\t        Cust ID    \t : " + nxtID);
        System.out.print(" \n\t NRIC \t : ");
        String nric_String = myObj.next();
        int nric = Integer.parseInt(nric_String);
        System.out.print(" \n\t First Name \t : ");
        String cname = myObj.useDelimiter("\n").next();
        System.out.print(" \n\t Second Name \t : ");
        cname += " " + myObj.useDelimiter("\n").next();   //cname = myObj.nextLine();

        System.out.print(" \n\t Address \t : ");
        String address = myObj.useDelimiter("\n").next();//address = myObj.nextLine();
        System.out.print(" \n\t Age \t : ");
        String age_String = myObj.next();
        int age = Integer.parseInt(age_String);

        //printHeader();
        if (Dao.insertCust(new smCust(nric, cname, address, age))) {
            // printFooter();
        }
        return 1;
    }

    public static int DisplayOptions() throws Exception {

        System.out.println(" \tFollowing are the options :: ");
        System.out.println(" \n\t\t1 >> Insert Cust ");

        System.out.println(" \n\t\t4 >> List Cust ");

        System.out.println(" \n\t\t0 >> Exit ");

        System.out.print(" Enter a numer to carry out the operation  :   ");
        int optVal;
        try {
            optVal = myObj.nextInt();
        } catch (Exception e) {

            optVal = -1;
        }
        return optVal;
    }

//    public static void printHeader() throws Exception {
//        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//        System.out.println(" ===============================================");
//    }
//
//    public static void printFooter() {
//        System.out.println(" ===============================================");
//    }
    public static void main(String[] args) throws Exception {
        while (true) {
            int optionVal = DisplayOptions();

            //printHeader();
            System.out.print("\t\t Option Selected : \t\t");
            switch (optionVal) {

                case 1:
                    System.out.println("Insert Cust  ");
                    //printFooter();
                    insCust();
                    break;

                case 4:
                    System.out.println("List Custs ::: ");
                    listCust();
                    break;

                case 0:
                    System.out.println("Exit");
                    //printFooter();
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

            //printFooter();
            System.out.print(" Press any key to continue.....");
            toContinue();
        }
    }

}
