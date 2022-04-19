import java.sql.*;

public class Type4DriverDemo{

    public static void main(String[] args) throws Exception {
        System.out.println("hello");
        Class.forName("com.mysql.cj.jdbc.Driver");  // this is optional
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/girrafe", "root", "London123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from branch");

        while (rs.next()){
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getDate(4));
        }
        con.close();
    }
}