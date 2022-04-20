import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
import java.util.*;

// this class reads input entered by the user and inserts that in the database
public class InsertDynamicInputMultipleRowsExample {

    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3306/jdbc_intro"; 
        String user = "root";
        String password = "London123";
        
        // Class.forName(driver); // this is optional in java 1.8
        Connection con = DriverManager.getConnection(jdbc_url, user, password);
        Statement st = con.createStatement();
        
        // get data from the user
        Scanner sc = new Scanner(System.in);

        // counter to count number of records inserted
        int count = 0;

        while (true) {
            System.out.println("Please Enter Employee Number");
            int eno = sc.nextInt();
            sc.nextLine();
            System.out.println("Please Enter Employee Name");
            String ename = sc.nextLine();
            System.out.println("Please Enter Employee Salary");
            double esal = sc.nextInt();
            sc.nextLine();
            System.out.println("Please Enter Employee Address");
            String eaddr = sc.nextLine();

            // insert data into the database
            // String sql_query = "insert into employees values (" + eno + ", \""+ ename +"\"," + esal + ",\"" + eaddr + "\" )";
            String sql_query = String.format("insert into employees values(%d, '%s',%f, '%s')", eno, ename, esal,
                    eaddr);
            st.executeUpdate(sql_query); // since this is a non-select query, executeUpdte() is used!
            count++;

            System.out.println("Would you like to enter more records: [yes/no]");
            String option = sc.nextLine();
            System.out.println(option);
            if(option.charAt(0)=='n' || option.charAt(0) == 'N'){
                System.out.println("Before break statement");
                break;
            }
        }

        System.out.println(count + " Dynamic Rows Inserted Successfully");
        con.close(); // optional in Java 1.8 onwards
    }
}