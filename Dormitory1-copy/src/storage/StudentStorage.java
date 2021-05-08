package storage;

import entity.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static util.DatabaseConnect.getDbConnect;

public class StudentStorage {

    Connection con;

    ObservableList<Student> list = FXCollections.observableArrayList();

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
        try {
            //PreparedStatement ins = con.prepareStatement("INSERT INTO inventory (name, piece) VALUES ('"+item.getName()+"', '"+parseInt(item.getPiece())+"')");
            //ins.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteItem(int id) {
        con = getDbConnect().connect();
        try {
            /*PreparedStatement delete = con.prepareStatement("DELETE FROM inventory WHERE id=?");
            delete.setInt(1, id);
            int rows = delete.executeUpdate();
            if (rows > 0) {
                System.out.println("Kullanıcı bilgisi silindi");
            }*/
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
