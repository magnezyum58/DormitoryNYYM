package storage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import static util.DatabaseConnect.getDbConnect;

public class LoginStorage {

    Connection con;

    public boolean isUserExist(String username, String password) {
        con = getDbConnect().connect();
        boolean isUserExist = false;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    isUserExist = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return isUserExist;
    }
}
