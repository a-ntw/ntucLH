package bankacc;

import accmap.AccMap_CRUD;
import corebanking.CoreBanking;
import java.util.Scanner;
import txhistory.FxTHist;
import txhistory.HistDAO;
import txhistory.TxHist;
import util.LogUtil;

public class BankOpe {

    public static Scanner myObj = new Scanner(System.in);
    public static int iteration = 1;

    public static void toContinue() {
        myObj.next();
    }

    public static String accNo; /// global var

    public static int DisplayOptions(String accNo) throws Exception {
        //LogUtil.IL.info(" Info Message From SavingOpe.DisplayOptions )");
        System.out.println("\n ************************************************"
                + "********************************************* ");
        System.out.println("\n\tOperations for accNo: " + accNo);
        System.out.println(" \t----------------------------------");
        System.out.println("\n ************************************************"
                + "********************************************* ");

        System.out.println("\tFollowing are the options :: ");
        System.out.println("\n\t1 >> Create New Account ");
        System.out.println("\n\t2 >> Check Balance");
        System.out.println("\n\t3 >> Deposit");
        System.out.println("\n\t4 >> Withdrawal");
        System.out.println("\n\t5 >> Transaction History");
        System.out.println("\n\t6 >> Transaction History (FX mode)");
        //System.out.println(" \n\t\t3 >> Find Accounts by Cust Name ");
        //System.out.println(" \n\t\t9 >> List ALL data (by Account no.)");
        System.out.println("\n\t9 >> Return to main ");
        System.out.println("\n\t0 >> Exit ");
        System.out.println("\n *************************************************"
                + "******************************************** ");
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
        System.out.println(" ==================================================="
                + "=========================================== ");

    }

    public static void printFooter() {
        System.out.println(" ==================================================="
                + "=========================================== ");
    }

    public static void Main(custinfo.Cust customer, BankAcc bkArray) throws Exception {

        //DisplayOptions(accNo);
        while (true) {
            String accNo = bkArray.getAccNo();

            int optionVal = DisplayOptions(accNo);
            System.out.print("\t Option Selected : \t\t");
            switch (optionVal) {

                case 1:
                    /**
                     * ******** MAP two tables to one table  *******
                     */
                    System.out.println("Create New Account  ");
                    //printFooter();
                    BankAcc newBankAcc = BankAccCrud.inSAacc(); // create acc
                    AccMap_CRUD.newAccMap(customer, newBankAcc);// create map
                    bkArray = newBankAcc; // transfer over
                    break;

                case 2:
                    System.out.println("Check Balance  ");
                    //SavingAccDao.getList(accNo).stream().forEach(System.out::println);
                    balanceByAccNo(bkArray);
                    break;
                case 3:
                    System.out.println("Deposit  ");
                    depositAmt(bkArray);
                    break;
                case 4:
                    System.out.println("Withdrawal  ");
                    withdrawalAmt(bkArray);
                    break;
                case 5:
                    System.out.println("Transaction History  ");
                    BankAccCrud.printRowHist(bkArray);
                    break;
                case 6:
                    System.out.println("Transaction History in FX  ");
                    printHist(bkArray);
                    break;
                case 8:
                    System.out.println("List all Acc No  ");
                    BankAccCrud.listAllAcc();
                    break;
                case 9:
                    System.out.println("Return");
                    printFooter();
                    CoreBanking.BankOpe();
                case 0:
                    System.out.println("Exit");
                    printFooter();
                    //Thread.sleep(4000);
                    System.exit(0);
                    break;
                default:
                    //printHeader();
                    System.out.println(" \n\n \t\t #### Invalid Option ####");
                    //printFooter();
                    Thread.sleep(4000);
                    break;
            }

            System.out.print("\nPress any key to continue.....");
            toContinue();
        }
    }

    /* 2 >> Check Balance */
    public static int balanceByAccNo(BankAcc s) throws Exception {
        LogUtil.IL.info(" Info Message From >> SavingOpe.balanceByAccNo()");
        printHeader();
        System.out.println("\n\tAccount :\t" + s.getAccNo() + "\n\tBalance :\t"
                + s.getBalance());
        return 0;
    }

    /* 3 >> Deposit */
    private static int depositAmt(BankAcc s) throws Exception {
        LogUtil.SL.info(" Severe Message From >> SavingOpe.depositAmt()");
        printHeader();
        //System.out.println("\n\t:: Transaction - Deposit :: ");
        double currBal = s.getBalance();
        System.out.println("\n\tCurrent balance\t: " + currBal);
        System.out.print("\n\tAmount to be deposit: ");
        int getAmt = myObj.nextInt();

        System.out.print("\n\tConfirm [y/n][Y/N]:: ");
        String resp = myObj.next();
        if (resp.equalsIgnoreCase("y")) {

            System.out.println("\n\tInitiating amount to deposit ::");
            printHeader();

            s.setBalance(currBal + getAmt);
            BankAccDao.updateAcc(s);
            int txcode = 11; // Saving Deposit for history
            txhistory.HistDAO.insTxNow(s.getIdSA(), txcode, getAmt); // for history

            System.out.println("\n\tNew balance \t : " + s.getBalance());

            printFooter();
        }

        return 0;
    }

    private static int withdrawalAmt(BankAcc s) throws Exception {
        LogUtil.SL.info(" Severe Message From >> SavingOpe.withdrawalAmt()");
        printHeader();
        //System.out.println("\n\t:: Transaction - Deposit :: ");
        double currBal = s.getBalance();
        System.out.println("\n\tCurrent balance\t: " + currBal);
        System.out.print("\n\tAmount to be withdraw: ");
        int getAmt = myObj.nextInt();

        System.out.print("\n\tConfirm [y/n][Y/N]:: ");
        String resp = myObj.next();
        if (resp.equalsIgnoreCase("y")) {

            System.out.println("\n\tInitiating amount to withdraw ::");
            printHeader();

            getAmt = 0 - getAmt; // negative conversion
            s.setBalance(currBal + getAmt);
            BankAccDao.updateAcc(s);
            int txcode = 15; // "Saving Withdrwal"
            txhistory.HistDAO.insTxNow(s.getIdSA(), txcode, getAmt); // for history
            System.out.println("\n\tNew balance \t : " + s.getBalance());

            printFooter();
        }

        return 0;
    }

    private static int printHist(BankAcc s) throws Exception {
        BankAccCrud.printRowHist(s);
        int Accid = s.getIdSA();

        TxHist.glovalVarInt = Accid; // Global variable for FX
        FxTHist.launchFtHist(Accid); // FX SceneBuild
        return 1;
    }

    public static void main(String[] args) throws Exception {

        int acc_id = 1;

        BankAcc accArray = BankAccDao.accRow(acc_id);
        //Main(accArray);

        //System.exit(0); // do not put this!
    }
}
