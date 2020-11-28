/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custinfo;

import corebanking.sqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antw
 */
public class forTestCust {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("\t\t Test for Customer ");
        System.out.println("\n========== (1) Insert new Customer ==========");
        //copied from Cust_CRUB insCust
        int nric = 1998203;
        String name = "Mr Inserting";
        String address = "InsertedAddesss";
        String email = "ins@vista.com";
        String mobileNo = "65437893";
        String dob = "1998-02-03";
        DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate DOBdate = LocalDate.parse(dob, sourceFormatter);

        LocalDateTime startDate = now();

        System.out.print("\n========== chkCustNric(nric)  ========== > ");

        if (chkCustNric(nric)) {
            
            CustDAO.insertCust(new Cust(nric, name, address, email, mobileNo,
                    DOBdate, startDate, (byte) 1));
            System.out.println(" ****** Inserted ****** ");

            //Cust_CRUB.listCustomers();
        }

        System.out.println("\n========== (5) listCustsByName ===========");
        Cust_CRUB.listCustsByName();

        System.out.println("\n========== (2) update Cust ========== ");
        Cust c = CustDAO.getCust(nric);
        c.setEmail(email);
        c.setAddress(address + " Rd");
        CustDAO.updateCust(c);
        
        System.out.println("\n========== (6) findCustByPhoneNo ==========");
        CustDAO.getCustomer(mobileNo).stream().forEach(System.out::println);

        System.out.println("\n========== (3) delCustomers() ==========");
        CustDAO.delCustomer(nric);
        
        System.out.println("\n========== (4) List All Customers() ==========");
        Cust_CRUB.listCustomers();

    }

    public static boolean chkCustNric(int nric) throws Exception {
        Statement stmt = sqlConnect.init();
        String qStmt = "Select count(*) from coreBanking.customer where nric = "
                + nric + ";";

        ResultSet rs = stmt.executeQuery(qStmt);
        if (rs.next() && rs.getInt(1) == 1) {
            System.out.println(" Already in database ");
        } else {
            System.out.println(" available ");
            return true;
        }
        return false;
    }

}
/*
        if (rs.next() && rs.getInt(1) == 1) {

int i=Integer.parseInt("200");  


 */
