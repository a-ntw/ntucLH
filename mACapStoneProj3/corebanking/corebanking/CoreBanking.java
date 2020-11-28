/*
pojo DAO & CRUD on sql, logging, locale, javafx
 */
package corebanking;

import bankacc.BankAccDao;
import bankacc.BankAccCrud;
import bankacc.BankOpe;
import bankacc.BankAcc;
import util.LogUtil;
import accmap.AccMap;
import accmap.AccMapDAO;
import custinfo.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import java.util.Scanner;

public class CoreBanking {

    public static Scanner myObj = new Scanner(System.in);
    public static int iteration = 1;

    public static void toContinue() {
        myObj.next();
    }

    public static int DisplayOptions(String displayMenu) throws Exception {
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
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
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println(" ==================================================="
                + "============================================================="
                + "==============");

    }

    public static void printFooter() {
        System.out.println(" ==================================================="
                + "============================================================="
                + "==============");
    }

    public static void CrudMap() {

    }

    public static String currName = "";

    /***** locale for different languages, >>> check on CoreBanking.bundles *****/
    public static void custlocale() {
        LogUtil.IL.info(" Info Message From >> CoreBanking.custlocale()");
        System.out.print("Enter the language [en/es/zh] : ");
        String language = myObj.next();
        System.out.print("Enter the country code [US/ES/CN] : ");
        String country = myObj.next();

        Locale locale = new Locale(language, country);
        System.out.println(" Locale finalized :::: " + locale.getDisplayLanguage());
        ResourceBundle msgs = ResourceBundle.getBundle("bundles.Msg_Bundle", locale);

        System.out.print(msgs.getObject("fname") + " : "); // Enter your First Name : 
        currName = myObj.next();
        String fname = "\n\t" + msgs.getObject("welcomemsg") + " " + currName;
        System.out.println(fname);
    }

    public static void coreMainCRUD() throws Exception {
        String CrudMenu = ("\n *************************************************"
                + "******************************************** "
                + "\n\t Customer CRUD Operations menu ::: " + currName
                + "\n\t----------------------------------"
                + "\n **********************************************************"
                + "*********************************** "
                + "\n\tFollowing are the options :: "
                + "\n\t\t1 >> Customer CRUD"
                + "\n\t\t2 >> Saving Account CRUD "
                + "\n\t\t3 >> Users Bank Operation "
                + "\n\t\t0 >> Exit "
                + "\n **********************************************************"
                + "*********************************** "
                // Create a Scanner object
                + "\nEnter a numer to carry out the operation  :   ");

        while (true) {
            int optionVal = DisplayOptions(CrudMenu);

            System.out.print("\t\t Option Selected : \t\t");
            switch (optionVal) {

                case 1:
                    System.out.println("Customer Particular  ");
                    //printFooter();
                    Cust_CRUD.Main();
                    break;

                case 2:
                    System.out.println("Saving Account ");
                    //printFooter();
                    BankAccCrud.Main();
                    break;
                case 3:
                    System.out.println("Bank Operation ");
                    //printFooter();
                    BankOpe();
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

    public static void BankOpe() throws Exception {
        LogUtil.IL.info(" Info Message From >> CoreBanking.BankOpe()");
        String SAMenu = ("\n ***************************************************"
                + "****************************************** "
                + "\n\tCustomer Bank Operations menu ::: "
                + "\n\t----------------------------------"
                + "\n **********************************************************"
                + "*********************************** "
                + "\n\tPlease Keyin the user's nric to cont :: "
                + "\n\n\tNric (digit only): ");

        int optionVal = DisplayOptions(SAMenu);

        int nric = optionVal;
        //int nric = 1234567;

        if (custinfo.CustDAO.noCustNric(nric)) {
            System.out.println("\n\tno NRIC in DB!");
            System.out.println("\n\tSystem Exit  .... ");
            System.exit(0);

        }

        printHeader();

        // for for customer name
        Cust c = CustDAO.getCust(nric);
        System.out.println("\tNric : " + nric + "\t\tCust name : " + c.getName());

        System.out.println("\n\tAccID \tAcc No  \ttype ");
        List<AccMap> s = AccMapDAO.accMapRow(nric);
        //s.stream().forEach(System.out::println);
        for (AccMap a : s) {
            int Accid = a.getAccid();
            System.out.println("\t" + Accid + "\t" + BankAccDao.getAccnoByID(Accid)
            );
        }
        System.out.print("\n\tSelect Account ID\t: ");
        int Accid = myObj.nextInt();
        String accNo = (BankAccDao.getAccnoByID(Accid));

        BankAcc currArray = BankAccDao.accRow(Accid);
        BankOpe.Main(c, currArray);
    }

    public static void main(String[] args) throws Exception {
        LogUtil.IL.info(" Info Message From >> CoreBanking.main()");

        custlocale();
        coreMainCRUD(); //** main
        //CrudOpe();
        //BankOpe(); // just Bank operation

    }

}
