import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;

public class InsertSingleRowExample{

    public static void main(String[] args) throws Exception{
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String user = "root";
        String password = "London123";
        String sql_query = "insert into employees values (100, \"Kramer\",1000, \"London\" )";
        // Class.forName(driver); // this is optional in java 1.8
        Connection con = DriverManager.getConnection(jdbc_url, user, password);
        Statement st = con.createStatement();
        int updateCount = st.executeUpdate(sql_query);  // since this is a non-select query, executeUpdte() is used!
        System.out.println("Single Row Inserted Successfully");
        System.out.println("number of rows inserted is:  " + updateCount);
        con.close();  // optional in Java 1.8
    }
}