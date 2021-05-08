package storage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import static util.DatabaseConnect.getDbConnect;

public class FirstFxmlStorage {

    Connection con;
    public String getNameSurname(String username, String password) {
        con = getDbConnect().connect();
        String nameSurname = null;
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    nameSurname = rs.getString("name") + " " + rs.getString("surname");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nameSurname;
    }

    /*public int getAuthority(String username, String password) {
        con = getDbConnect().connect();
        int authority = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    System.out.println(rs.getInt(authority));
                    authority = rs.getInt(authority);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return authority;
    }*/

}
