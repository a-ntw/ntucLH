package jdbc_app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/world?useTimezone=true&serverTimezone=UTC&"
                            + "user=root&password=mysql");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from city");

            System.out.println(" ID \t Name \t\t CountryCode \t District \t Population");
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "\t:\t" + rs.getString("Name") + "\t:\t" + rs.getString("CountryCode") + "\t:\t" + rs.getString("District") + "\t:\t" + rs.getInt("Population"));
            }
        } catch (Exception e) {
            System.out.println(" Exception here ....  " + e.getMessage());
        }
    }

}
