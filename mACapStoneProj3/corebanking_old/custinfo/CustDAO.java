package custinfo;

import com.mysql.cj.jdbc.CallableStatement;
import corebanking.sqlConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class CustDAO {

    public static int getNextID() {
        int nxtID = 0;
        try {
            Statement stmt = sqlConnect.init();
            String nxID = "select max(nric) from coreBanking.customer;";
            ResultSet rs = stmt.executeQuery(nxID);
            rs.next();
            nxtID = rs.getInt(1) + 1;
        } catch (Exception e) {
            System.out.println(" Exception from CustomerDAO :: " + e.getMessage());
            e.printStackTrace();
        }
        return nxtID;
    }

    public static boolean chkCustNric(int nric) throws Exception {
        Statement stmt = sqlConnect.init();
        String qStmt = "Select count(*) from coreBanking.customer where nric = "
                + nric + ";";

        ResultSet rs = stmt.executeQuery(qStmt);
        if (rs.next() && rs.getInt(1) == 1) {       // **********
            System.out.println(" Already in database... ");
            return false;
        } else {
            //System.out.println(" available ");
        }
        return true;
    }

    public static List<Cust> listOrderByName() throws Exception {
        Connection conn = sqlConnect.initConn();
        List<Cust> custList = new ArrayList<>();
        String qStmt = "{CALL GetCust()}";

        CallableStatement cstmt = (CallableStatement) conn.prepareCall(qStmt);
        ResultSet rs = cstmt.executeQuery();

        while (rs.next()) {
            Cust c = new Cust(rs.getInt("nric"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("mobileNo"),
                    rs.getDate("DOB").toLocalDate(),
                    rs.getObject("startDate", LocalDateTime.class),
                    rs.getByte("active"));
            custList.add(c);
        }
        return custList;
    }

    /* Execute this before using Callable Statements
    DELIMITER $$

    CREATE procedure GetCust()
    BEGIN
            select nric, name, address, email, mobileNo
            from coreBanking.customer
            order by name;
    END$$
    DELIMITER ;

    call GetCustomers();
     */
    public static Cust getCust(int nric) throws Exception {
        Statement stmt = sqlConnect.init();
        Cust cust = null;
        String qStmt = "Select * from coreBanking.customer where nric = " + nric + ";";

        ResultSet rs = stmt.executeQuery(qStmt);
        while (rs.next()) {
            cust = (new Cust(rs.getInt("nric"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("mobileNo"),
                    rs.getDate("DOB").toLocalDate(),
                    rs.getObject("startDate", LocalDateTime.class),
                    rs.getByte("active")
            ));
        }
        return cust;
    }

    public static List<Cust> getCustomer(String mobileNo) throws Exception {
        Connection conn = sqlConnect.initConn();
        List<Cust> custList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.customer where mobileNo = ? ";

        PreparedStatement pStmt = conn.prepareStatement(qStmt);
        pStmt.setString(1, mobileNo);

        ResultSet rs = pStmt.executeQuery();
        while (rs.next()) {
            custList.add(new Cust(rs.getInt("nric"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("mobileNo"),
                    rs.getDate("DOB").toLocalDate(),
                    rs.getObject("startDate", LocalDateTime.class),
                    rs.getByte("active")
            ));
        }
        return custList;

    }

    public static boolean updateCust(Cust c) throws Exception {
        Statement stmt = sqlConnect.init();
        String updStmt = "Update coreBanking.customer set email = '"
                + c.getEmail() + "', address = '"
                + c.getAddress() + "' where nric = " + c.getNric() + ";";

        if (stmt.executeUpdate(updStmt) > 0) {
            System.out.println(" Update Success ");
        } else {
            System.out.println(" Update Failed ");
        }
        return true;
    }

    public static boolean delCustomer(int cid) throws Exception {
        Statement stmt = sqlConnect.init();
        String delStmt = "delete from CoreBanking.customer where nric = " + cid + ";";

        int result = stmt.executeUpdate(delStmt);
        if (result > 0) {
            System.out.println(" Delete Success ");
        } else {
            System.out.println(" Delete  Fail ");
        }
        return true;
    }

    public static boolean insertCust(Cust c) throws Exception {
        Statement stmt = sqlConnect.init();

        String insStmt = "insert into coreBanking.customer (nric, name, address,"
                + " email, mobileNo, DOB, startDate, active) VALUES("
                + c.getNric() + ", '" + c.getName() + "',  '"
                + c.getAddress() + "', '" + c.getEmail() + "', '" + c.getMobileNo() + "', '"
                + c.getDOB().toString() + "', '" + c.getStartDate().toString() + "', '"
                + c.getActive() + "');";

        int result = stmt.executeUpdate(insStmt);

        if (result > 0) {
            System.out.println(" Insert Success ");
        } else {
            System.out.println(" Insert Fail ");
        }

        return true;
    }

    public static List<Cust> listCustomer() throws Exception {
        Statement stmt = sqlConnect.init();
        List<Cust> custList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.customer;";

        ResultSet rs = stmt.executeQuery(qStmt);
        while (rs.next()) {
            custList.add(new Cust(rs.getInt("nric"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("mobileNo"),
                    rs.getDate("DOB").toLocalDate(),
                    rs.getObject("startDate", LocalDateTime.class),
                    rs.getByte("active")
            ));
        }
        return custList;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("First Part: " + CustDAO.listCustomer().get(0));
        CustDAO.listCustomer().stream().forEach(System.out::println);
    }
}
