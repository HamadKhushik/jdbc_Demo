import java.util.*;
import java.io.FileOutputStream;
import java.sql.*;

public class ExecuteQueryUsingNon_SelectQuery {

// mySQL returns an exception when usin executeQuery() method for update queries
// preparedStatement should be used for updateQueries using executeQuery() method

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String username = "root";
        String pwd = "London123";

        Connection con = DriverManager.getConnection(url, username, pwd);
        Statement st = con.createStatement();


        String sql_query = "update from employees set ename='Elaine B' where eno=101";

        ResultSet rs = st.executeQuery(sql_query);
        

        while (rs.next()) {
         
            System.out.format("%-5d%-10s%-8.2f%-10s\n", rs.getInt(1), rs.getString(2), rs.getDouble(3),
                    rs.getString(4));
        }
        // close connection - optional in java 1.8 onwards
        con.close();
    }
}
