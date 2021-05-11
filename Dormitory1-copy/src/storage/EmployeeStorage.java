package storage;

import entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static util.DatabaseConnect.getDbConnect;

public class EmployeeStorage {

    Connection con;

    ObservableList<Employee> list = FXCollections.observableArrayList();

    public ObservableList fillEmployeeList() {
        con = getDbConnect().connect();
        list.clear();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String tcNo = rs.getString("tcNo");
                String username = rs.getString("username");
                String password = rs.getString("password");
                list.add(new Employee(id, username, password, name, surname, tcNo));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void userInsert(Employee user) {
        con = getDbConnect().connect();
        try {
            PreparedStatement ins = con.prepareStatement("INSERT INTO user (username, password, name, surname, tcNo, authority) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getSurname() + "', '" + user.getTcNo() + "', 'user' )");
            ins.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteUser(int id) {
        con = getDbConnect().connect();
        try {
            PreparedStatement delete = con.prepareStatement("DELETE FROM user WHERE id=?");
            delete.setInt(1, id);
            int rows = delete.executeUpdate();
            if (rows > 0) {
                System.out.println("Kullanıcı bilgisi silindi");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateEmployee(int id, Employee emp) {
        con = getDbConnect().connect();
        try {
            String sql = "UPDATE user set name='" + emp.getName() + "', surname='" + emp.getSurname() + "', tcNo='" + emp.getTcNo() + "', username='" + emp.getUsername() + "', password='" + emp.getPassword() + "' WHERE id=('" + id + "')";
            Statement statement = con.createStatement();
            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("Kullanıcı bilgisi güncellendi");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*public List<Employee> userRead() {
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
    }*/
}
