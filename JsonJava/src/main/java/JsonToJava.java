import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JsonToJava {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, JsonGenerationException, JsonMappingException {
        // My Sql Connection to Database
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        // Giving Details to CustomerDetails class
        ArrayList<CustomerDetails> a = new ArrayList<CustomerDetails>();
        // Giving connection to the Driver
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
            CustomerDetails c=new CustomerDetails();
            // 3 different json files , 3 different java objects
            // Used set methods to put the information into Customer Details methods
            c.setCourseName(rs.getString(1));
            c.setPurchasedDate(rs.getString(2));
            c.setAmount(rs.getInt(3));
            c.setLocation(rs.getString(4));
            // Adding java objects from sql query
            a.add(c);

            }
        for (int i = 0; i <a.size();i++){
            ObjectMapper oj = new ObjectMapper();
            oj.writeValue(new File("C:\\Users\\Miche\\IdeaProjects\\FullStackAutomationProject\\JsonJava\\customerInfo" + i+ ".json"),a.get(i));
        }

        conn.close();
    }

}
