package storage;

import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static util.DatabaseConnect.getDbConnect;

public class StudentStorage {

    Connection con;

    ObservableList<Student> list = FXCollections.observableArrayList();
    RoomManagementStorage rm;

    public ObservableList fillStudentList() {
        con = getDbConnect().connect();
        list.clear();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Student");
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String tcNo = rs.getString("tcNo");
                String bedNo = rs.getString("bedNumber");
                String roomNo = rs.getString("roomNumber");
                String studentNo = rs.getString("studentNumber");
                list.add(new Student(id, name, surname, tcNo, studentNo, roomNo, bedNo));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertItem(Student stu) {
        con = getDbConnect().connect();
        rm = new RoomManagementStorage();
        try {
            PreparedStatement ins = con.prepareStatement("INSERT INTO Student (name, surname, tcNo, roomNumber, bedNumber, studentNumber) VALUES ('" + stu.getName() + "', '" + stu.getSurname() + "', '" + stu.getTcNo() + "', '" + stu.getRoomNumber() + "', '" + stu.getBedNumber() + "', '" + stu.getStudentNumber() + "')");
            ins.executeUpdate();
            rm.updateBed(stu);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void deleteItem(int id) {
        con = getDbConnect().connect();
        rm = new RoomManagementStorage();
        try {
            PreparedStatement delete = con.prepareStatement("DELETE FROM Student WHERE id=?");
            delete.setInt(1, id);
            int rows = delete.executeUpdate();
            if (rows > 0) {
                System.out.println("Kullanıcı bilgisi silindi");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }

    public void updateItem(int id, Student stu) {
        con = getDbConnect().connect();
        try {
            String sql = "UPDATE Student set name='" + stu.getName() + "', surname='" + stu.getSurname() + "', tcNo='" + stu.getTcNo() + "', roomNumber='" + stu.getRoomNumber() + "', bedNumber='" + stu.getBedNumber() + "', studentNumber='" + stu.getStudentNumber() + "' WHERE id=('" + id + "')";
            Statement statement = con.createStatement();
            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("Kullanıcı bilgisi güncellendi");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
