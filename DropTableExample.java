import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;

public class DropTableExample{

    public static void main(String[] args) throws Exception{
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String user = "root";
        String password = "London123";
        String sql_query = "drop table employees";
        // Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url, user, password);
        Statement st = con.createStatement();
        int rowsEffected = st.executeUpdate(sql_query);  // since this is a non-select query, executeUpdte() is used!
        System.out.println("Table Dropped Successfully");
        System.out.println("number of rows effected is:  " + rowsEffected);
        con.close();  // optional in Java 1.8
    }
}