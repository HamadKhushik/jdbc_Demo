import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
import java.util.*;

// this class selects * from employees with employee names starting with certain characters

public class SelectRangeOfRecordsExample2 {

    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String user = "root";
        String password = "London123";

        // Class.forName(driver); // this is optional in java 1.8 onwards
        Connection con = DriverManager.getConnection(jdbc_url, user, password);
        Statement st = con.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter starting characters of name");
        String name = sc.nextLine() + "%";

        String sql_query = String.format("select * from employees where ename like '%s'" , name);
        ResultSet rs  = st.executeQuery(sql_query); // since this is a select query, executeQuery() is used!
        System.out.println("ENO \t ENAME \t ESAL \t EADDR");
        System.out.println("----------------------------------------------");

        // process Result Set
        boolean flag = true;
        while (rs.next()){

            System.out.format("%5d%10s%10s%10s%n" , rs.getInt(1), rs.getString(2), rs.getDouble(3),  rs.getString(4));
            // System.out.println();

            flag = false;
        }

        if (flag){
            System.out.println("No Matching records found!");
        }
        con.close(); // optional in Java 1.8 onwards
    }
}