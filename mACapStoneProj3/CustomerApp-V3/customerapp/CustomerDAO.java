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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            ResultSet rs = stmt.executeQuery(nxID); // 0 records
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
    
    
    
    public static ObservableList <Customer> listCustomers() throws Exception{
        Statement stmt = CustomerDAO.init();
        ObservableList <Customer> custList = FXCollections.observableArrayList();
        String qStmt = "Select * from Bank.Customer;";
        
        ResultSet rs = stmt.executeQuery(qStmt);
        while(rs.next()){
            Customer c = new Customer(rs.getInt("custID"),rs.getString("custName"),rs.getDate("DOB").toLocalDate(),rs.getString("email"),rs.getString("phoneNo"),rs.getByte("active"));
            System.out.println(c);
            custList.add(c);
        }
        return custList;
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
        String updStmt = "Update Bank.Customer set email = '" + c.getEmail() + "', phoneNO = '" + c.getPhoneNo()+ "', active = " + c.getActive() + " where custID = " + c.getCustID() + ";";
        
        if(stmt.executeUpdate(updStmt) > 0){
           System.out.println(" Update Success ");
        }else {
            System.out.println(" Update Failed ");
        }
        return true;
    }
}
