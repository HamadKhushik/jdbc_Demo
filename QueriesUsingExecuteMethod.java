import java.util.*;
import java.io.FileOutputStream;
import java.sql.*;

// this program reads the query entered by user at runtime and executes it using the execute() method
public class QueriesUsingExecuteMethod {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String username = "root";
        String pwd = "London123";

        Connection con = DriverManager.getConnection(url, username, pwd);
        Statement st = con.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the SQL query:");
        String sql_query = sc.nextLine();

        boolean selectQuery = st.execute(sql_query);

        if (selectQuery) {
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                // System.out.println(
                        // rs.getInt(1) + '\t' + rs.getString(2) + '\t' + rs.getDouble(3) + '\t' + rs.getString(4));
                        System.out.format("%-5d%-10s%-8.2f%-10s\n", rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
            }
        } else {
            int count = st.getUpdateCount();
            System.out.println("Number of lines effected is: " + count);
        }

        // close connection - optional in java 1.8 onwards
        con.close();

    }
}
