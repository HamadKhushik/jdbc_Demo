import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
import java.util.*;

// this class selects particular columns from employees and process them in the ResultSet

public class SelectingParticularColumnsExample {

    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String user = "root";
        String password = "London123";

        // Class.forName(driver); // this is optional in java 1.8 onwards
        Connection con = DriverManager.getConnection(jdbc_url, user, password);
        Statement st = con.createStatement();

        String sql_query = String.format("select ename, eaddr from employees");
        ResultSet rs  = st.executeQuery(sql_query); // since this is a select query, executeQuery() is used!
        System.out.println("ENAME \t EADDR");
        System.out.println("----------------------------------------------");

        // process Result Set
        boolean flag = true;
        while (rs.next()){

            System.out.format("%-10s%-10s%n" , rs.getString(1), rs.getString(2));

            flag = false;
        }

        if (flag){
            System.out.println("No Matching records found!");
        }
        con.close(); // optional in Java 1.8 onwards
    }
}