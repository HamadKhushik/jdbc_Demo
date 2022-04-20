import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
import java.util.*;

// this class updates the record in the db
public class UpdateSingleRowExample {

    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String user = "root";
        String password = "London123";

        // Class.forName(driver); // this is optional in java 1.8
        Connection con = DriverManager.getConnection(jdbc_url, user, password);
        Statement st = con.createStatement();

        String sql_query = "update Employees set esal=1200 where eno=101";
        int updatedRecord = st.executeUpdate(sql_query); // since this is a non-select query, executeUpdte() is used!
       
        System.out.println(updatedRecord + " rows updated  Successfully");
        con.close(); // optional in Java 1.8 onwards
    }
}