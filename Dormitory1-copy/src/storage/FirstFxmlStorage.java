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
    public int getId(String username,String password){
        con = getDbConnect().connect();
        int id=0;
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    id=rs.getInt("id");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    public boolean getAuthority(int id) {
        con = getDbConnect().connect();
        boolean authority=false;
        System.out.println(id);
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                if (id==rs.getInt("id")){
                    if(rs.getString("authority").equals("admin")){
                        authority=true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return authority;
    }

}
