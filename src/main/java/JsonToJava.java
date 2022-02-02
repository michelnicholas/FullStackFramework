import java.sql.*;

public class JsonToJava {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // My Sql Connection to Database
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","Imani11234!");

        // Object of Statement Class will help us to execute queries
        Statement st = conn.createStatement();
        ResultSet rs =  st.executeQuery("select * from CustomerInfo where location = 'Asia' and purchasedDate=curdate() LIMIT 1;");
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
            // Giving Details to CustomerDetails class
            CustomerDetails c = new CustomerDetails();

            // Used set methods to put the information into Customer Details methods
            c.setCourseName(rs.getString(1));
            c.setPurchasedDate(rs.getString(2));
            c.setAmount(rs.getInt(3));
            c.setLocation(rs.getString(4));

            // Print the information from the Sql Library to console by using Getter Methods
            System.out.println(c.getCourseName());
            System.out.println(c.getPurchasedDate());

        }
        conn.close();
    }

}
