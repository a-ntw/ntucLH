Customer_CRUB.java
``` java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Customer_CRUD {

    public static Scanner myObj = new Scanner(System.in);
    public static int iteration = 1;

    public static void toContinue() {
        myObj.next();
    }

    public static String printPretty() {
        String s = "\n  |";
        for (int i = 0; i <= iteration; i++) {
            s += "---";
        }

        return s + " >> ";
    }

    public static int listCustomers() throws Exception {
        printHeader();
        System.out.println("\tID  \tName \t\t\tDOB   \t\t   Email  \t\tPhoneNo  \tStatus");
        printFooter();
        CustomerDAO.listCustomer().stream().forEach(System.out::println);
        printFooter();
        return 1;
    }    
    
    public static int listCustomersByDOB() throws Exception {
        printHeader();
        System.out.println("\tID  \tName \t\t\tDOB   \t\t   Email  \t\tPhoneNo  \tStatus");
        printFooter();
        CustomerDAO.listCustomerOrderByDOB().stream().forEach(System.out::println);
        printFooter();
        return 1;
    }
    
    public static int findCustomerByPhoneNo() throws Exception {
        printHeader();
        System.out.print(" \tEnter the PhoneNo to Find :: ");
        String phoneNo = myObj.next();
        
        printHeader();
        System.out.println("\tID  \tName \t\t\tDOB   \t\t   Email  \t\tPhoneNo  \tStatus");
        printFooter();
        CustomerDAO.getCustomer(phoneNo).stream().forEach(System.out::println);
        printFooter();
        return 1;
    }

    public static int delCustomers() throws Exception {
        listCustomers();
        System.out.print(" \tEnter the Customer ID to Delete :: ");
        int cid = myObj.nextInt();
        System.out.print(" \tAre you sure [y/n][Y/N]:: ");
        String resp = myObj.next();
        if (resp.equalsIgnoreCase("y")) {
            System.out.println(" Initiating delete for Customer ID ::" + cid);
            printHeader();
            CustomerDAO.delCustomer(cid);
            printFooter();
        }
        return 1;
    }

    public static int updCustomers() throws Exception {
        listCustomers();
        System.out.print(" \tEnter the Customer ID to Update :: ");
        int cid = myObj.nextInt();
        System.out.print(" \t You can only update Email and PhoneNo [Y/N][y/n]:: ");
        String resp = myObj.next();
        if (resp.equalsIgnoreCase("y")) {
            System.out.println(" Initiating update for Customer ID ::" + cid);
            printHeader();
            Customer c = CustomerDAO.getCustomer(cid);
            System.out.println(" Select Customer ::: ");
            System.out.println(c);
            printFooter();

            System.out.println(" \n\t\t   Current Email   \t : " + c.getEmail());
            System.out.print(" \n\t\t   New Email       \t : ");
            c.setEmail(myObj.next());
            System.out.println(" \n\t\t    Current Phone    \t : " + c.getPhoneNo());
            System.out.print(" \n\t\t    New  Phone          \t : ");
            c.setPhoneNo(myObj.next());
            CustomerDAO.updateCustomer(c);
            printFooter();
        }
        return 1;
    }

    public static int insCustomer() throws Exception {
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//
        int nxtID = CustomerDAO.getNextID();
        System.out.println(" \tEnter the following details  :: ");
        printFooter();
        System.out.println(" \n\t\t        Customer ID    \t : " + nxtID);
        System.out.print(" \n\t\t        First Name     \t : ");
        String name = myObj.next();
        System.out.print(" \n\t\t        Last Name     \t : ");
        name += " " + myObj.next();    //name = myObj.nextLine();
        System.out.print(" \n\t\t        Date Of Birth  \t : ");
        String dob = myObj.next();
        DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dob, sourceFormatter);
        System.out.print(" \n\t\t        Email          \t : ");
        String email = myObj.next();
        System.out.print(" \n\t\t        Phone          \t : ");
        String phoneNo = myObj.next();
        printHeader();
        if (CustomerDAO.insertCustomer(new Customer(nxtID, name, LocalDate.parse(dob, DateTimeFormatter.ISO_DATE), email, phoneNo, (byte) 1))) {
            printFooter();
        }
        return 1;
    }

    public static int DisplayOptions() throws Exception {
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\n ********************************************************************************************* ");
        System.out.println("\n\t Customer CRUD Operations ::: ");
        System.out.println(" \t----------------------------------");
        System.out.println("\n ********************************************************************************************* ");

        System.out.println(" \tFollowing are the options :: ");
        System.out.println(" \n\t\t1 >> Insert Customer ");
        System.out.println(" \n\t\t2 >> Update Customer ");
        System.out.println(" \n\t\t3 >> Delete Customer ");
        System.out.println(" \n\t\t4 >> List Customer "); 
        System.out.println(" \n\t\t5 >> List Customers Order By DOB ");
        System.out.println(" \n\t\t6 >> Find Customers By PhoneNo ");
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

            printHeader();
            System.out.print("\t\t Option Selected : \t\t");
            switch (optionVal) {

                case 1:
                    System.out.println("Insert Customer  ");
                    printFooter();
                    insCustomer();
                    break;
                case 2:
                    System.out.println("Update Customer ::: ");
                    updCustomers();
                    break;
                case 3:
                    System.out.println("Delete Customer ::: ");
                    delCustomers();
                    break;
                case 4:
                    System.out.println("List Customers ::: ");
                    listCustomers();
                    break;
                case 5:
                    System.out.println("List Customers ::: ");
                    listCustomersByDOB();
                    break;
                case 6:
                    System.out.println("Find Customers By Phone No::: ");
                    findCustomerByPhoneNo();
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
                    printFooter();
                    Thread.sleep(4000);
                    break;
            }

            printFooter();
            System.out.print(" Press any key to continue.....");
            toContinue();
        }
    }

}

```

CustomerDAO.java
``` java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

/**
 *
 * @author chand
 */
public class CustomerDAO {

    public static Statement init() throws Exception {
        Connection conn = initConn();

        return conn.createStatement();
    }
    
    public static Connection initConn() throws Exception {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/bank?useTimezone=true&serverTimezone=UTC&"
                        + "user=root&password=mysql_80");

        return conn;
    }
    
    public static int getNextID(){
        int nxtID = 0;
        try{
            Statement stmt = CustomerDAO.init();
            String nxID = "select max(custID) from bank.customer;";
            ResultSet rs = stmt.executeQuery(nxID);
            rs.next();
            nxtID = rs.getInt(1) + 1 ;        
        }catch(Exception e){
            System.out.println(" Exception from CustomerDAO :: " + e.getMessage());
            e.printStackTrace();
        }
        return nxtID;
    }
    
    public static boolean insertCustomer(Customer c) throws Exception{
        Statement stmt = CustomerDAO.init();
        
        String insStmt = "insert into Customer (custID, custName, DOB, email, phoneNo, active) "
                + " values(" + c.getCustID() + 
                ",\"" + c.getCustName() + "\",DATE(\"" + c.getDOB().toString() +"\"),"
                + "\"" + c.getEmail() + "\"," + c.getPhoneNo() + "," + c.getActive() +");";
        
        int result = stmt.executeUpdate(insStmt);
        
        if(result > 0){
            System.out.println(" Insert Success ");
        }else {
            System.out.println(" Insert Fail ");
        }
        
        return true;
    }    
    
    public static boolean delCustomer(int cid) throws Exception{
        Statement stmt = CustomerDAO.init();     
        String delStmt = "delete from bank.Customer where custID = " + cid + ";";
        
        int result = stmt.executeUpdate(delStmt);
        if(result > 0){
            System.out.println(" Delete Success ");
        }else {
            System.out.println(" Delete  Fail ");
        }
        return true;
    }
    
    public static List <Customer> listCustomer() throws Exception{
        Statement stmt = CustomerDAO.init();
        List <Customer> custList = new ArrayList<>();
        String qStmt = "Select * from Bank.Customer;";
        
        ResultSet rs = stmt.executeQuery(qStmt);
        while(rs.next()){
            custList.add(new Customer(rs.getInt("custID"),rs.getString("custName"),rs.getDate("DOB").toLocalDate(),rs.getString("email"),rs.getString("phoneNo"),rs.getByte("active"))            );
        }
        return custList;
    }  
    
    public static List <Customer> listCustomerOrderByDOB() throws Exception{
        Connection conn = CustomerDAO.initConn();
        List <Customer> custList = new ArrayList<>();
        String qStmt = "{CALL GetCustomers()}";
        
        CallableStatement cstmt = (CallableStatement)conn.prepareCall(qStmt);
        ResultSet rs = cstmt.executeQuery();
        while(rs.next()){
            Customer c = new Customer(rs.getInt("custID"),rs.getString("custName"),rs.getDate("DOB").toLocalDate(),rs.getString("email"),rs.getString("phoneNo"),(byte)1);
            custList.add(c);
        }
        return custList;
    }
    
    public static Customer getCustomer(int custID) throws Exception{
        Statement stmt = CustomerDAO.init();
        Customer cust = null;
        String qStmt = "Select * from Bank.Customer where custID = " + custID + ";";
        
        ResultSet rs = stmt.executeQuery(qStmt);
        while(rs.next()){
            cust = new Customer(rs.getInt("custID"),rs.getString("custName"),rs.getDate("DOB").toLocalDate(),rs.getString("email"),rs.getString("phoneNo"),rs.getByte("active"));
        }
        return cust;
    }
    
    public static List <Customer> getCustomer(String phoneNo) throws Exception{
        Connection conn = CustomerDAO.initConn();
        List <Customer> custList = new ArrayList<>();
        String qStmt = "Select * from Bank.customer where phoneNo = ? ";
        
        PreparedStatement pStmt = conn.prepareStatement(qStmt);
        pStmt.setString(1, phoneNo);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            custList.add(new Customer(rs.getInt("custID"),rs.getString("custName"),rs.getDate("DOB").toLocalDate(),rs.getString("email"),rs.getString("phoneNo"),rs.getByte("active")));
        }
        return custList;
    }
    
    public static boolean updateCustomer(Customer c) throws Exception{
        Statement stmt = CustomerDAO.init();
        String updStmt = "Update Bank.Customer set email = '" + c.getEmail() + "', phoneNO = '" + c.getPhoneNo()+ "' where custID = " + c.getCustID() + ";";
        
        if(stmt.executeUpdate(updStmt) > 0){
           System.out.println(" Update Success ");
        }else {
            System.out.println(" Update Failed ");
        }
        return true;
    }
}

```

Customer.java
``` java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp;

import java.time.LocalDate;

/**
 *
 * @author chand
 */
public class Customer {
    private String custName;
    private LocalDate DOB;
    private byte active;
    private String email;
    private int custID;
    private String phoneNo;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    
    public Customer(int custID, String custName, LocalDate DOB, String email, String phoneNo, byte active ) {
        this.custName = custName;
        this.DOB = DOB;
        this.active = active;
        this.email = email;
        this.custID = custID;
        this.phoneNo = phoneNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

//    @Override
//    public String toString() {
//        return "\t" + custID + "\t " + custName + "\t\t" + DOB + "\t" + email  + " \t " + phoneNo + " \t" + (active==1 ? true : false);
//    }
    
    
}

```

customer_tbl_data.cssv
``` yaml
"custID";"custName";"DOB";"Picture";"email";"active";"phoneNo"
1;"ChandraSekhar";"2020-10-10";"";"chandra@ajancs.com";1;"123456789"
2;"Steve Jobs";"2001-01-01";"";"steve@apple.com";1;"12341234"
3;"Humpty Dumpty";"1967-01-01";"";"humpty@dumpty.com";1;"283728378"
4;"Donald Trump";"1940-01-01";"";"donald@putin.com";1;"911911911"
5;"Tennis Ball";"1977-11-28";"";"tennis@open.org";1;"2312312312"
7;"Joe Biden";"1940-09-08";"";"joebiden@usa.gov";1;"119119119"
8;"From GUI";"2013-11-07";"";"gui@from.com";1;"23872837823"

```

CUSTOMER_tbl_ddI.txt
``` sql
CREATE TABLE `customer` (
  `custID` int NOT NULL,
  `custName` varchar(45) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Picture` blob,
  `email` varchar(45) DEFAULT NULL,
  `active` tinyint DEFAULT NULL,
  `phoneNo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`custID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



// Other useful commands


SELECT * FROM bank.customer;

SELECT * FROM bank.customer where custID = 7;


INSERT INTO `bank`.`customer`
(`custID`,`custName`,`DOB`,`email`,`active`,`phoneNo`)
VALUES
(10,
'Dumpty',
'2020-02-02',
'dumpty@abc.com',
1,
'123123123');



select custID, custName, DOB, phoneNo, email
from bank.customer;

select custID, custName, DOB, phoneNo, email
from bank.customer
order by DOB;

DELETE FROM `bank`.`customer`
WHERE custID = 4;


// Execute this before using Callable Statements 

DELIMITER $$

CREATE procedure GetCustomers()
BEGIN
	select custID, custName, DOB, phoneNo, email
	from bank.customer
	order by DOB;
END$$
DELIMITER ;


call GetCustomers();

```



mysql_80
