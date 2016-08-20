
import java.sql.Connection;
import java.sql.DriverManager;


public class DB {
    static Connection getCon()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts", "root", "123");
        return c;
    
    }
}
