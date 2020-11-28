package bankacc;

import java.time.LocalDate;
import static java.time.LocalDate.now;

public class Test {

    public static int listByAccNo() throws Exception {
        System.out.print(" \tEnter the AccountNo (xxx-xxx-xxx-x):");
        String accNo = "098-765-432-1";	//String accNo = myObj.next();
        System.out.println(
                "\nID  \tAccNo \t\tbalance \tintRate \taccOpenDate "
                + "\taccClosedDate \tminBal");

        BankAccDao.getList(accNo).stream().forEach(System.out::println);
        return 0;

    }

    public static void main(String[] args) throws Exception {
        listByAccNo();

        String accNo = "123-456-789-0";
        System.out.println("\nAccount no : " + accNo);

        System.out.println("Acc Info: \n" + BankAccDao.getList(accNo) + "\n");

        BankAccDao.listSA().stream().forEach(System.out::println);

        double interestRate = 0.0752342424;
        String s = String.format("%.3f", interestRate);
        System.out.println("\ns = " + s);

        // Need to change idSA & AccNo
        int accid = BankAccDao.getNextID(); // get next ID
        String AccNo = "112-444-777-9";
        double balance = 3000;
        double intRate = 0.075;
        LocalDate accOpenDate = now();
        //LocalDate accOpenDate = LocalDate.parse("2000-10-02");
        LocalDate accClosedDate = null; // not necessayr
        double minBal = 200;

        int nxtID = BankAccDao.getNextID();

        System.out.println("==== S A Testing : Insert ====== ");

        BankAccDao.insertSAacc(new BankAcc(nxtID, AccNo, balance,
                intRate, accOpenDate, accClosedDate, minBal));

        BankAcc row = BankAccDao.accRow(accid);

        System.out.println("==== S A Testing : Deposit ====== ");
        double amt = 200;
        row.setBalance(row.getBalance() + amt);
        BankAccDao.updateAcc(row);
        int txcode = 11; // Saving Deposit for history
        txhistory.HistDAO.insTxNow(row.getIdSA(), txcode, amt); // for history

        System.out.println("==== S A Testing : Delete ====== ");
        BankAccDao.delAcc(row);

        System.out.println("==== S A Testing : History ====== ");
        BankAccCrud.printRowHist(row);

    }
}
/*  Yet to use this
        System.out.println(loadEmp().stream().collect(Collectors.counting()));

        System.out.println(loadEmp()
                .stream()
                .map(e -> e.getlName())
                .collect(Collectors.toList()));
 */
 /*
                Stream.of("Monday", "Tuesday", "Wednesday", "Thursday")
                .filter(s -> s.startsWith("T"))
                .forEach(s -> System.out.println("Matching Days: " + s));
 */
