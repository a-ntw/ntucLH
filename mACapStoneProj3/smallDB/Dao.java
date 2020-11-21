
package smallDB;

//import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


public class Dao {

    public static Statement init() throws Exception {
        Connection conn = initConn(); 

        return conn.createStatement();
    }
    
    public static Connection initConn() throws Exception {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        // package >Properties >Libraries > ClassPath= mysqlCJ
        conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/smallDB?"
                        + "useTimezone=true&serverTimezone=UTC&"
                        + "user=root&password=mysql_80");

        return conn;
    }
    
//    public static int getNextID(){
//        int nxtID = 0;
//        try{
//            Statement stmt = Dao.init();
//            String nxID = "select max(custID) from smallDB.cust;";
//            ResultSet rs = stmt.executeQuery(nxID);
//            rs.next();
//            nxtID = rs.getInt(1) + 1 ;        
//        }catch(Exception e){
//            System.out.println(" Exception from smsCustDAO :: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return nxtID;
//    }
    
    public static boolean insertCust(smCust c) throws Exception{
        Statement stmt = Dao.init();

        String insStmt = "insert into smallDB.cust (nric, cname, address, age) "
                + "VALUES("+ c.getNric() + ",\"" + c.getName() + "\",  \"" 
                + c.getAddress() + "\", " + c.getAge() 
                + ");";
        System.out.println(insStmt);
        
        int result = stmt.executeUpdate(insStmt);
        
        if(result > 0){
            System.out.println(" Insert Success ");
        }else {
            System.out.println(" Insert Fail ");
        }
        
        return true;
    }    
    
    
    public static List <smCust> listCust() throws Exception{
        Statement stmt = Dao.init();
        List <smCust> custList = new ArrayList<>();
        String qStmt = "Select * from smallDB.Cust;";

        
        ResultSet rs = stmt.executeQuery(qStmt);
        while(rs.next()){
            custList.add(new smCust(rs.getInt("nric"),rs.getString("cname"),
                    rs.getString("address"),rs.getInt("age")));
            
        }
        return custList;
    }  

    
    public static void main(String[] args) throws Exception {
        Dao.listCust().stream().forEach(System.out::println);
        System.out.println("First Part: " + Dao.listCust().get(0));

    } 
}
