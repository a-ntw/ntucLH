/*********** mySQL connection default ****************/
package corebanking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class sqlConnect {
        public static Statement init() throws Exception {
        Connection conn = initConn();
        return conn.createStatement();
    }

    public static Connection initConn() throws Exception {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/coreBanking?useTimezone=true&serverTimezone=Asia/Singapore&"
                        + "user=root&password=mysql_80");
        return conn;
    }
}

/*
    just change to 'mysql_80'
*/