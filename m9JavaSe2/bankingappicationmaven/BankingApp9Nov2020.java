package com.mycompany.bankingappicationmaven;

import java.util.Collections;
import java.util.Set;
import java.util.Comparator;
import java.util.function.Predicate;

public class BankingApp9Nov2020 {

    // functioal interface - an interface that has a single function
    public interface IReportingCondition {

        boolean test(ITransaction transRec);
    }

    public interface IDsiplayCondition {

        void display(ITransaction trans);
    }

    public static void main(String[] args) {

        // create a runtime error
        //String aString = "A";
        //int aNumber = Integer.parseInt(aString);
        try {
            UOBBank firstUOBCustomer = new UOBBank();
            DoTransaction(firstUOBCustomer, 1001, "Eva Longoria", "Savings", 10000, 2000);

            UOBBank secondUOBCustomer = new UOBBank();
            DoTransaction(secondUOBCustomer, 1002, "Micheal Shepard", "Current", 12000, 2000);

            CitiBank firstCTCustomer = new CitiBank();
            DoTransaction(firstCTCustomer, 2001, "John Steven", "Gold", 200000, 10000);

            Finance firstFinCustomer = new Finance();
            DoTransaction(firstFinCustomer, 3001, "Eric Lee", "Savings", 300000, 20000);

            Utility.saveTransaction(firstUOBCustomer);
            Utility.saveTransaction(secondUOBCustomer);
            Utility.saveTransaction(firstCTCustomer);
            Utility.saveTransaction(firstFinCustomer);
            //Utility.transactionStorage.add(123.45); // arraylist can store anything

            //Set<ITransaction> anotherAccountStorage = Set.of(firstUOBCustomer,
            //        secondUOBCustomer, firstCTCustomer, firstFinCustomer);
            // diplay all the transaction records...
            //Utility.transactionStorage.sort(c);
            // Sort the Collection by account name
            // SortByAccountName nameSort = new SortByAccountName();
            // Collections.sort(Utility.transactionStorage, nameSort);
            // Sort the Collection by account type
            //SortByAccountType typeSort = new SortByAccountType();
            //Collections.sort(Utility.transactionStorage, typeSort);
            // Sort the Collection by account name
            SortByAccountNo accountNoSort = new SortByAccountNo();
            Collections.sort(Utility.transactionStorage, accountNoSort);

            System.out.println("List of all transactions:");
            Predicate<ITransaction> allRecords = (ITransaction trans) -> true;
            displayAccounts(allRecords);

            System.out.println("List of customer with account balance < 100000");
            Predicate<ITransaction> LessThanHundredRecords = (
                    ITransaction trans) -> trans.getAccountBalance() < 100_000;
            displayAccounts(LessThanHundredRecords);

            System.out.println("List of customer with account balance > 100000");
            Predicate<ITransaction> moreThanHundredRecords = (
                    ITransaction trans) -> trans.getAccountBalance() > 100_000;
            displayAccounts(moreThanHundredRecords);

            System.out.println("List of customer with account type = savings ");
            Predicate<ITransaction> savingsRecords = (
                    ITransaction trans) -> trans.getAccountType() == "Savings";
            displayAccounts(savingsRecords);

            System.out.println("Information about a particular customer");
            displayTransaction((ITransaction trans) -> {
                System.out.println("Account No: " + trans.getAccountNo());
                System.out.println("Account Name: " + trans.getAccountName());
                System.out.println("Account Balance: " + trans.getAccountBalance());
            }, firstUOBCustomer);

            // Lambda expression being used to retrive collection items
            System.out.println("Lambda expression retriving collection items:");
            Utility.transactionStorage.forEach(bankAccount -> {
                System.out.print(((ITransaction) bankAccount).getAccountNo());
                System.out.print("-");
                System.out.println(((ITransaction) bankAccount).getAccountName());
            });

            System.out.println("Lambda expression retriving specific collection items");
            Utility.transactionStorage.stream().filter(
                    accType -> accType.getAccountType().equals("Savings")
            ).forEach(bankAccount -> {
                System.out.print(((ITransaction) bankAccount).getAccountNo());
                System.out.print("-");
                System.out.println(((ITransaction) bankAccount).getAccountName());
            });

            System.out.println("Lambda expression that sorts the collection");
            Utility.transactionStorage.stream().filter(
                    accType -> accType.getAccountType().equals("Savings")
            ).sorted(Comparator.comparing(ITransaction::getAccountBalance))
                    .forEach(bankAccount -> {
                        System.out.print(bankAccount.getAccountNo());
                        System.out.print("-");
                        System.out.print(bankAccount.getAccountName());
                        System.out.print("-");
                        System.out.println(bankAccount.getAccountBalance());
                    });

        } catch (Exception e) {
            System.out.println("Something went wrong, contact the admin..");
            System.out.println("Report this error:" + e.toString());
        }

    }

    //private static void displayAccounts(IReportingCondition conditionLogic) {
    private static void displayAccounts(Predicate conditionLogic) {

        for (ITransaction retrieveTransaction : Utility.transactionStorage) {
            if (conditionLogic.test(retrieveTransaction)) {
                System.out.println(retrieveTransaction.getAccountNo() + "-"
                        + retrieveTransaction.getAccountName() + "-"
                        + retrieveTransaction.getAccountBalance());
            }
        }
        System.out.println();
    }

    private static void displayTransaction(IDsiplayCondition consumerLogic,
            ITransaction trans) {
        consumerLogic.display(trans);
    }

    private static void DoTransaction(ITransaction customer, int acctNo, String acctName,
            String acctType, double depAmount, double withAmount) throws Exception {
        customer.setAccountNo(acctNo);
        customer.setAccountName(acctName);
        customer.setAccountType(acctType);
        customer.Deposit(depAmount);
        customer.Withdrawal(withAmount);
        customer.DisplayTransaction();
    }

}
