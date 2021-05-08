
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {
    private static DatabaseConnect dbConnect=new DatabaseConnect();
    
    private DatabaseConnect() {
        
    }

    public static DatabaseConnect getDbConnect() {
        return dbConnect;
    }
 
    private Connection c;
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://awsmysql.cp0np9yvdsbt.us-east-2.rds.amazonaws.com:3306/AwsDatabase", "admin", "12345679");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
