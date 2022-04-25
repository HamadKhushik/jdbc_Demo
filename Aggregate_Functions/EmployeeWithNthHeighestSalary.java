import java.util.*;
import java.sql.*;

// this program finds the employee details with  'nth' heighest salary in the db, where 'n' is entered by the user dynamically
public class EmployeeWithNthHeighestSalary {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String username = "root";
        String pwd = "London123";

        Connection con = DriverManager.getConnection(url, username, pwd);
        Statement st = con.createStatement();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the required rank of heighest salary");
        int n = Math.abs(sc.nextInt()); sc.nextLine();
        // count function -> returns the number of rows in table
        String sql_query = String.format("select * from (select eno, ename, esal, eaddr, rank() over (order by esal desc) ranking from employees)my_rank where ranking = %d", n);
        ResultSet rs = st.executeQuery(sql_query);
        boolean flag = true;;
        while (rs.next()){  // if there are more than one emp with heighest sal
            System.out.printf("%-5d%-10s%-8.1f%-10s%n", rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
            flag = false;
        }

        if (flag){
            System.out.println("No Matching Records found!");
        }
        
        // close connection - optional in java 1.8 onwards
        con.close();
    }
}
