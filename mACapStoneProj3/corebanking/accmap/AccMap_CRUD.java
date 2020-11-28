package accmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccMap_CRUD {

    //*******  set global variable for inter use between object      ********/
    private static List<AccMap> globalMapL = new ArrayList<>();
    //private static AccMap globalMap; 

    public static Scanner myObj = new Scanner(System.in);
    public static int iteration = 1;

    public static void toContinue() {
        myObj.next();
    }

    public static int DisplayOptions(String displayMenu) throws Exception {
        System.out.print(displayMenu);

        int optVal;
        try {
            optVal = myObj.nextInt();
        } catch (Exception e) {

            optVal = -1;
        }
        return optVal;
    }

    public static void printHeader() throws Exception {
        System.out.println(" =================================================="
                + "===========================================");

    }

    public static void printFooter() {
        System.out.println(" =================================================="
                + "===========================================");
    }

    public static int findMapByNric() throws Exception {
        System.out.print("Enter the Nric to Find :: ");
        String nric_String = myObj.next();
        int nric = Integer.parseInt(nric_String);

        printHeader();
        System.out.println("ID \tNric \tAcc_ID \tStatus");
        //printFooter();
        AccMapDAO.accMapRow(nric).stream().forEach(System.out::println);
        printFooter();
        return 1;
    }

    public static int ListMap() throws Exception {
        printHeader();
        System.out.println("id \tNRIC \tAcc_ID \tStatus");
        printFooter();
        AccMapDAO.ListMap().stream().forEach(System.out::println);
        printFooter();
        return 1;
    }

    public static boolean newAccMap(custinfo.Cust currCust, bankacc.BankAcc newAccNo) throws Exception {

        accmap.AccMap accMapRow;
        //custinfo.Cust currCust = null;
        //bankacc.BankAcc newAccNo = null;

        /**
         * ****** CAST ******
         */
        accMapRow = new AccMap(currCust.getNric(), newAccNo.getIdSA(), (byte) 1);
        if (AccMapDAO.insertMap(accMapRow)) {
            printHeader();
        }
        return true;
    }

    public static int insMap() throws Exception {
        System.out.print(" \n\t NRIC (only digits) \t : ");
        String nric_String = myObj.next();
        int nric = Integer.parseInt(nric_String);
        // Check if nric is in Customer database first
        if (custinfo.CustDAO.noCustNric(nric)) {
            System.out.println("no NRIC in DB!");
            return 0;
        }
        System.out.println("Current available account");
        System.out.println("ID \tNric \tAcc_ID \tStatus");
        globalMapL = AccMapDAO.accMapRow(nric);
        globalMapL.stream().forEach(ea -> {
            try {
                System.out.println(bankacc.BankAccDao.accRow(ea.getAccid()));
            } catch (Exception ex) {
                Logger.getLogger(AccMap_CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        System.out.println("\n\n KIV ====> refer to BankOpe .... \n\n  ");

        return 0;
    }

    public static void CustAccMap() throws Exception {
        String MapMenu = ("\n *************************************************"
                + "******************************************** "
                + "\n\t Customer Account Mapping CRUD menu ::: "
                + "\n\t----------------------------------"
                + "\n *********************************************************"
                + "************************************ "
                + "\n\tFollowing are the options :: "
                + "\n\t\t1 >> Insert Customer Account link "
                + "\n\t\t4 >> List all rows "
                + "\n\t\t6 >> Find Map by Nric"
                //+ "\n\t\t7 >> Display Nric and AccountNo "
                + "\n\t\t0 >> Exit "
                + "\n *********************************************************"
                + "************************************ "
                // Create a Scanner object
                + "\nEnter a numer to carry out the operation  :   ");

        while (true) {
            int optionVal = DisplayOptions(MapMenu);

            System.out.print("\t\t Option Selected : \t\t");
            switch (optionVal) {

                case 1:
                    System.out.println("Insert Customer Account link  ");
                    printFooter();
                    insMap();
                    break;

                case 4:
                    System.out.println("List all rows ");
                    printFooter();
                    ListMap();
                    break;
                case 6:
                    System.out.println("Find map by nric ");
                    printFooter();
                    findMapByNric();
                    break;
                case 7:
                    System.out.println("Display Nric with AccountNo");
                    printFooter();
                    //findMapByNric();
                    break;
                case 0:
                    System.out.println("Exit");
                    printFooter();
                    //Thread.sleep(4000);
                    System.exit(0);
                    break;
                default:
                    printHeader();
                    System.out.println(" \n\n \t\t #### Invalid Option ####");
                    printFooter();
                    //Thread.sleep(4000);
                    break;
            }

            System.out.print(" Press any key to continue.....");
            toContinue();
        }
    }

    public static void main(String[] args) throws Exception {

        CustAccMap();
    }

}
