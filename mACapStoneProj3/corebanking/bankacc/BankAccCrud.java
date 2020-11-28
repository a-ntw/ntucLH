package bankacc;

import accmap.AccMapDAO;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.Scanner;

public class BankAccCrud {

    //*******  set global variable for inter use between object      ********/
    private static BankAcc globalAcc; // ref to 8 >> Acc Balance & history 

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
        System.out.println(" \n\t\t1 >> Create Account ");
        System.out.println(" \n\t\t2 >> List data by Account no. ");
        System.out.println(" \n\t\t3 >> Account detail ");
        System.out.println(" \n\t\t4 >> Delete Account ");
        System.out.println(" \n\t\t5 >> List AccNo by AccID. ");
        System.out.println(" \n\t\t6 >> Update Account ");
        System.out.println(" \n\t\t7 >> Update Balance ");
        System.out.println(" \n\t\t8 >> Acc Balance & history ");
        System.out.println(" \n\t\t9 >> List all accounts details ");
        System.out.println(" \n\t\t0 >> Exit ");

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
        System.out.println(" =================================================="
                + "============================================================"
                + "================");
    }

    public static void printFooter() {
        System.out.println(" =================================================="
                + "============================================================"
                + "================");
    }

    //* 1 >> Create S Account  */
    public static BankAcc inSAacc() throws Exception {
        int nxtID = BankAccDao.getNextID();
        System.out.println("\tEnter the following details  :: ");
        printFooter();
        System.out.println("\n\t\tSA Account ID\t : " + nxtID);
        System.out.print(" \n\t\tAccount No\t : ");
        String accNo = myObj.next();

        double balance = 0;

        System.out.print(" \n\t\tInterest Rate:\t : ");
        double intRate = Double.parseDouble(myObj.next());

        LocalDate accOpenDate = now();
        System.out.print(" \n\t\tAccountOpenDate:\t : " + accOpenDate);
//      String oDate = myObj.next();
//      DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//      //LocalDate date = LocalDate.parse(dob, sourceFormatter);
//      LocalDate accOpenDate = LocalDate.parse(oDate, DateTimeFormatter.ISO_DATE);

        LocalDate accClosedDate = null; // not necessay yet

        System.out.print(" \n\t\tMinimum Balance:\t : ");
        double minBal = Integer.parseInt(myObj.next());
        //int i=Integer.parseInt("200");  

        if (BankAccDao.insertSAacc(new BankAcc(nxtID, accNo, balance,
                intRate, accOpenDate, accClosedDate, minBal))) {
            printFooter();
        }
        return BankAccDao.accRow(nxtID);
        
        //if (AccMapDAO.insertMap(new AccMap()))

    }

    //* 2 >> List data by Account no.  */
    public static int listByAccNo() throws Exception {
        printHeader();
        System.out.print(" \tEnter the AccountNo (xxx-xxx-xxx-x):");
        String accNo = myObj.next();

        printHeader();
        System.out.println(
                "ID  \tAccNo \t\tbalance \tintRate \taccOpenDate "
                + "\taccClosedDate \tminBal");
        BankAccDao.getList(accNo).stream().forEach(System.out::println);
        return 0;

    }

    //* 3 >> Account detail.  */
    public static int infoByAccNo() throws Exception {
        printHeader();
        System.out.println(
                "ID  \tAccNo \t\tbalance \tintRate \taccOpenDate "
                + "\tClosedDate \tminBal");
        printFooter();
        System.out.print(" \tEnter the Account idSA: ");
        //int idSA = 1; // for testing
        int idSA = myObj.nextInt();

        printHeader();
        BankAcc s = BankAccDao.accRow(idSA);
        System.out.println(s);
        return 0;
    }

    //* 4 >> Delete Account].  */
    public static int delByAccID() throws Exception {
        System.out.print(" \tEnter the Account id TO DELETE: ");
        int idSA = myObj.nextInt();
        BankAcc row = BankAccDao.accRow(idSA);
        System.out.println(row);
        System.out.print(" \tAre you sure [y/n][Y/N]:: ");
        String resp = myObj.next();
        if (resp.equalsIgnoreCase("y")) {
            System.out.println(" Initiating delete for Account with ID ::" + idSA);
            printHeader();
            BankAccDao.delAcc(row);
            printFooter();
        }
        return 1;
    }

    //* 5 >> List AccNo by AccID.  */
    public static int accnoByAccid() throws Exception {
        printHeader();
        System.out.println(
                "ID  \tAccNo \t\tbalance \tintRate \taccOpenDate "
                + "\tClosedDate \tminBal");
        printFooter();
        System.out.print(" \tEnter the Account idSA: ");
        //int idSA = 1; // 
        int idSA = myObj.nextInt();

        printHeader();
        BankAcc s = BankAccDao.accRow(idSA);
        System.out.println(s);
        System.out.println("Account No: " + s.getAccNo());
        return 0;
    }

    /* 6 >> Update Account  */
    public static int updAcc() throws Exception {
        listAllAcc();
        System.out.println("\tEnter the Account ID to update ");
        int idSA = myObj.nextInt();
        System.out.print(" \t You can only update Balance, Int Rate and minBal [Y/N][y/n]:: ");
        String resp = myObj.next();
        if (resp.equalsIgnoreCase("y")) {
            System.out.println(" Initiating update for Account ID ::" + idSA);
            printHeader();
            BankAcc s = BankAccDao.accRow(idSA);
            System.out.println(s);
            printFooter();

            System.out.println(" \n\t\t Current balance \t : " + s.getBalance());
            System.out.print(" \n\t\t     New balance \t : ");
            s.setBalance(myObj.nextInt());

            System.out.println(" \n\t\t Current Int Rate \t : " + s.getIntRate());
            System.out.print(" \n\t\t     New Int Rate \t : ");
            s.setIntRate(myObj.nextFloat());

            System.out.println(" \n\t\t Current min bal \t : " + s.getMinBal());
            System.out.print(" \n\t\t     New min bal \t : ");
            s.setMinBal(myObj.nextInt());

            BankAccDao.updateAcc(s);
            printFooter();
        }

        return 1;
    }

    /* 7 >> Update Balance  */
    public static int updBal() throws Exception {
        System.out.print("\tEnter the Account ID to update ");
        int idSA = myObj.nextInt();
        System.out.println(" Initiating update for Account ID ::" + idSA);
        printHeader();
        BankAcc s = BankAccDao.accRow(idSA);
        System.out.println(s);
        printFooter();

        System.out.println(" \n\t\t Current balance \t : " + s.getBalance());
        System.out.print(" \n\t\t     New balance \t : ");
        s.setBalance(myObj.nextInt());
        BankAccDao.updateAcc(s);
        printFooter();

        return 1;
    }

    //* 8 >> Acc Balance  */
    public static int balanceByAccID() throws Exception {
        printHeader();
        System.out.print(" \tEnter the AccountNo idSA: ");
        int idSA = myObj.nextInt();

        printHeader();
        BankAcc s = BankAccDao.accRow(idSA);
        globalAcc = s; // set the globalAcc for next object
        System.out.println(s);
        System.out.println("Balance: " + s.getBalance());
        return 0;
    }

    //* + 8 >> Acc Balance  - Print Row Hist */
    public static int printRowHist(BankAcc s) throws Exception {
        printHeader();
        /*just print out the row */
        System.out.println("\n\tTransaction History for \t: " + s.getAccNo());
        int Accid = s.getIdSA();
        System.out.println("\n\tDATE \t\t\tCODE \tDESCRIPTION \tAMOUNT");
        txhistory.HistDAO.getHistByAccid(Accid).stream().forEach(ea
                -> System.out.println(ea.toStringV3()));
        printFooter();
        return 1;
    }

    //* 9 >> List all accounts details  */
    public static int listAllAcc() throws Exception {
        printHeader();
        System.out.println(
                "ID  \tAccNo \t\tbalance \tintRate \taccOpenDate "
                + "\tClosedDate \tminBal");
        printFooter();

        //SavingAccDao.listSA().stream().forEach(System.out::println);
        BankAccDao.listSA().stream().forEach(eaRow -> {
            System.out.println(eaRow);
        });

        printFooter();
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
                    listByAccNo();
                    break;
                case 3:
                    System.out.println("Acc detail");
                    infoByAccNo();
                    break;
                case 4:
                    System.out.println("Delete Account");
                    delByAccID();
                    break;
                case 5:
                    System.out.println("AccNo by AccID");
                    accnoByAccid();
                    break;
                case 6:
                    System.out.println("Update Account");
                    updAcc();
                    break;
                case 7:
                    System.out.println("Update Balance");
                    updBal();
                    break;
                case 8:
                    System.out.println("Acc Balance & history");
                    balanceByAccID();
                    printRowHist(globalAcc);
                    break;
                case 9:
                    System.out.println("List all Acc No  ");
                    BankAccCrud.listAllAcc();
                    break;
                case 0:
                    System.out.println("Exit");
                    printFooter();
                    //Thread.sleep(4000);
                    System.exit(0);
                    break;
                default:
                    //printHeader();
                    System.out.println(" \n\n \t\t #### Invalid Option ####");
                    printFooter();
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
