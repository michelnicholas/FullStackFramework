import java.sql.*;

public class JsonToJava {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // My Sql Connection to Database
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","Imani11234!");

        // Object of Statement Class will help us to execute queries
        Statement st = conn.createStatement();
        ResultSet rs =  st.executeQuery("select * from CustomerInfo where location = 'Asia' and purchasedDate=curdate();");
//       rs.next();
//       rs.getString(1);
//       rs.getString(2);
//       rs.getInt(3);
//       rs.getString(4);
//       rs.next();
//       rs.getString(1);
//       rs.getString(2);
//       rs.getInt(3);
//       rs.getString(4);
        while (rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getInt(3));
            System.out.println(rs.getString(4));
        }
        conn.close();
    }

}
