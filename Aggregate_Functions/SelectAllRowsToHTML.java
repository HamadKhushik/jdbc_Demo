import java.util.*;
import java.io.FileOutputStream;
import java.sql.*;

// this program selects * from employees and displays them in HTML
public class SelectAllRowsToHTML {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/jdbc_intro";
        String username = "root";
        String pwd = "London123";

        Connection con = DriverManager.getConnection(url, username, pwd);
        Statement st = con.createStatement();
        
        // count function -> returns the number of rows in table
        String sql_query = "select * from employees";
        ResultSet rs = st.executeQuery(sql_query);

        String data = "<html> <body bgcolor='green' text='white'> <center> <table border='2' style='width:50%'>";
        data = data + "<tr style='height:50px'><td>ENO</td><td>ENAME</td><td>ESAL</td><td>EADDR</td></tr>";
        
        while (rs.next()){  // if there are more than one emp with heighest sal
           data = data + "<tr style='height:50px'><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getDouble(3) + "</td><td>" + rs.getString(4) + "</td></tr>";
        }

        data = data + "</table></center></body></html>";
        // write the data to HTML file
        FileOutputStream fos = new FileOutputStream("emp.html");
        byte[] b = data.getBytes();
        fos.write(b);  // write byte to HTML, fos only writes byte[]
        fos.flush();  // good programming practice to flush fos after writing

        System.out.println("Open emp.html to view the contents of query");

        fos.close();   // close the file output stream
        // close connection - optional in java 1.8 onwards
        con.close();
    }
}
