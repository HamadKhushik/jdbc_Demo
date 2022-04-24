import java.util.*;
import java.sql.*;

public class EmployeeWithHeighestSalary {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String username = "root";
        String pwd = "London123";

        Connection con = DriverManager.getConnection(url, username, pwd);
        Statement st = con.createStatement();

        // count function -> returns the number of rows in table
        String sql_query = "select * from employees where esal in(select max(esal) from employees)";
        ResultSet rs = st.executeQuery(sql_query);
        while (rs.next()){  // if there are more than one emp with heighest sal
            System.out.printf("%-5d%-10s%-8.1f%-10s%n", rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
        }
        
        // close connection - optional in java 1.8 onwards
        con.close();
    }
}
