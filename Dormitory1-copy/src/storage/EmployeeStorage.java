package storage;

import entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static util.DatabaseConnect.getDbConnect;

public class EmployeeStorage {
    Connection con;
    
    public void userInsert(Employee user) {
        con = getDbConnect().connect();
        try {
            PreparedStatement ins = con.prepareStatement("INSERT INTO user (username, password) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "')");
            ins.executeUpdate();
            System.out.println(user.getUsername() + user.getPassword());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Employee> userRead() {
        List<Employee> eList = new ArrayList<Employee>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                eList.add(new Employee(rs.getString("username"), rs.getString("password"), rs.getInt("EmployeeId"), rs.getString("name"), rs.getString("surname"), rs.getString("tcNo")));
            }
        } catch (Exception e) {
            System.out.println();
        }
        return eList;
    }

}
