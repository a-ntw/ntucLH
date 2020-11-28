package custinfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cust_CRUD {

    public static Scanner myObj = new Scanner(System.in);
    public static int iteration = 1;

    public static void toContinue() {
        myObj.next();
    }

    /* 1 >> Insert Customer    */
    public static int insCust() throws Exception {
        System.out.println(" \tEnter the following details  :: ");
        //printFooter();
        System.out.print(" \n\t NRIC (only digits) \t : ");
        String nric_String = myObj.next();
        int nric = Integer.parseInt(nric_String);
        System.out.print(" \n\t First Name \t : ");
        String name = myObj.useDelimiter("\n").next();
        System.out.print(" \n\t Second Name \t : ");
        name += " " + myObj.useDelimiter("\n").next();    //name = myObj.nextLine();

        System.out.print(" \n\t Address \t : ");
        String address = myObj.useDelimiter("\n").next(); //address = myObj.nextLine();

        System.out.print(" \n\t Email \t : ");
        String email = myObj.useDelimiter("\n").next();

        System.out.print(" \n\t Mobile No. \t : ");
        String mobileNo = myObj.next();

        System.out.print(" \n\t Date Of Birth (yyyy-MM-dd) \t : ");
        String dob = myObj.next();
        DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate DOBdate = LocalDate.parse(dob, sourceFormatter);

        LocalDateTime startDate = now();

        if (CustDAO.noCustNric(nric)) {
            CustDAO.insertCust(new Cust(nric, name, address, email, mobileNo,
                    DOBdate, startDate, (byte) 1));
        }

        return 1;
    }

    /* 2 >> Update Customer  */
    public static int updCust() throws Exception {
        listCustomers();
        System.out.print(" \tEnter the Customer Nric to Update :: ");
        int cid = myObj.nextInt();
        System.out.print(" \t You can only update Email and Address [Y/N][y/n]:: ");
        String resp = myObj.next();
        if (resp.equalsIgnoreCase("y")) {
            System.out.println(" Initiating update for Customer ID ::" + cid);
            printHeader();
            Cust c = CustDAO.getCust(cid);
            System.out.println(" Select Customer ::: ");
            System.out.println(c);
            printFooter();

            System.out.println(" \n\t\t Current Email \t : " + c.getEmail());
            System.out.print(" \n\t\t New Email \t : ");
            c.setEmail(myObj.next());
            System.out.println(" \n\t\t Current Addresss \t : " + c.getAddress());
            System.out.print(" \n\t\t Addresss \t : ");
            c.setAddress(myObj.useDelimiter("\n").next());
            CustDAO.updateCust(c);
            printFooter();
        }
        return 1;
    }

    /* 3 >> Delete Customer  */
    public static int delCustomers() throws Exception {
        listCustomers();
        System.out.print(" \tEnter the Customer ID to Delete :: ");
        int cid = myObj.nextInt();
        System.out.print(" \tAre you sure [y/n][Y/N]:: ");
        String resp = myObj.next();
        if (resp.equalsIgnoreCase("y")) {
            System.out.println(" Initiating delete for Customer ID ::" + cid);
            printHeader();
            CustDAO.delCustomer(cid);
            printFooter();
        }
        return 1;
    }

    /* 4 >> List All Customer  */
    public static int listCustomers() throws Exception {
        //printHeader();
        System.out.println("ID \tName \t\tAddress \tEmail  \t\tPhoneNo "
                + "\tDOB\t\tStart Date \tStatus");
        //printFooter();
        CustDAO.listCustomer().stream().forEach(System.out::println);
        //printFooter();
        return 1;
    }

    /* 5 >> List Customers Order By Name  */
    public static int listCustsByName() throws Exception {
        printHeader();
        System.out.println("ID \tName \t\tAddress \tEmail  \t\tPhoneNo "
                + "\tDOB\t\tStart Date" + "\tStatus");
        printFooter();
        CustDAO.listOrderByName().stream().forEach(System.out::println);
        printFooter();
        return 1;
    }

    /* 6 >> Find Customers By PhoneNo  */
    public static int findCustByPhoneNo() throws Exception {
        printHeader();
        System.out.print(" \tEnter the PhoneNo to Find :: ");
        String mobileNo = myObj.next();

        printHeader();
        System.out.println("ID \tName \t\tAddress \tEmail  \t\tPhoneNo "
                + "\tDOB\t\tStart Date" + "\tStatus");
        printFooter();
        CustDAO.getCustomer(mobileNo).stream().forEach(System.out::println);
        printFooter();
        return 1;
    }

    public static int DisplayOptions() throws Exception {
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\n *************************************************"
                + "******************************************** ");
        System.out.println("\n\t Customer CRUD Operations ::: ");
        System.out.println(" \t----------------------------------");
        System.out.println("\n *************************************************"
                + "******************************************** ");

        System.out.println(" \tFollowing are the options :: ");
        System.out.println(" \n\t\t1 >> Insert Customer ");
        System.out.println(" \n\t\t2 >> Update Customer ");
        System.out.println(" \n\t\t3 >> Delete Customer ");
        System.out.println(" \n\t\t4 >> List All Customer ");
        System.out.println(" \n\t\t5 >> List Customers Order By Name ");
        System.out.println(" \n\t\t6 >> Find Customers By PhoneNo ");
        System.out.println(" \n\t\t0 >> Exit ");

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
                + "===========================================================================");

    }

    public static void printFooter() {
        System.out.println(" ==================================================="
                + "===========================================================================");
    }

    public static void Main() throws Exception {
        //public static void main(String[] args) throws Exception {
        while (true) {
            int optionVal = DisplayOptions();

            System.out.print("\t\t Option Selected : \t\t");
            switch (optionVal) {

                case 1:
                    System.out.println("Insert Customer  ");
                    //printFooter(); 
                    insCust();
                    break;
                case 2:
                    System.out.println("Update Customer ::: ");
                    updCust();
                    break;
                case 3:
                    System.out.println("Delete Customer ::: ");
                    delCustomers();
                    break;
                case 4:
                    System.out.println("List All Customers ::: ");
                    listCustomers();
                    break;
                case 5:
                    System.out.println("List Customers By Name ::: ");
                    listCustsByName();
                    break;
                case 6:
                    System.out.println("Find Customers By Phone No::: ");
                    findCustByPhoneNo();
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
