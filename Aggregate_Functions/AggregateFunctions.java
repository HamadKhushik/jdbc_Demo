import java.util.*;
import java.sql.*;

public class AggregateFunctions {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String username = "root";
        String pwd = "London123";

        Connection con = DriverManager.getConnection(url, username, pwd);
        Statement st = con.createStatement();

        // count function -> returns the number of rows in table
        String sql_query = "select count(*) from employees";
        System.out.println("Total number of rows in employees table");
        runQuery(st, sql_query);
        // max salary in the employees table
        sql_query = "select max(esal) from employees";
        System.out.println("Maximum Salary in the employees table");
        runQuery(st, sql_query);        
        // min salary in the employees table
        sql_query = "select min(esal) from employees";
        System.out.println("Minimum Salary in the employees table");
        runQuery(st, sql_query);
        // close connection - optional in java 1.8 onwards
        con.close();
    }

    private static void  runQuery(Statement st, String query) throws Exception{

        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            System.out.println(rs.getInt(1));
        }
    }

}
