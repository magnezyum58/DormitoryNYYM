package storage;

import entity.Inventory;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static util.DatabaseConnect.getDbConnect;

public class InventoryStorage {

    Connection con;

    ObservableList<Inventory> list = FXCollections.observableArrayList();

    public ObservableList fillInventoryList() {
        con = getDbConnect().connect();
        list.clear();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from inventory");
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String name = rs.getString("name");
                String piece = rs.getString("piece");
                list.add(new Inventory(id, name, piece));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertItem(Inventory item) {
        con = getDbConnect().connect();
        try {
            PreparedStatement ins = con.prepareStatement("INSERT INTO inventory (name, piece) VALUES ('" + item.getName() + "', '" + parseInt(item.getPiece()) + "')");
            ins.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteItem(int id) {
        con = getDbConnect().connect();
        try {
            PreparedStatement delete = con.prepareStatement("DELETE FROM inventory WHERE id=?");
            delete.setInt(1, id);
            int rows = delete.executeUpdate();
            if (rows > 0) {
                System.out.println("Kullanıcı bilgisi silindi");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateItem(int id, Inventory item) {
        con = getDbConnect().connect();
        try {
            String sql = "UPDATE inventory set name='" + item.getName() + "', piece='" + parseInt(item.getPiece()) + "'  WHERE id=('" + id + "')";
            Statement statement = con.createStatement();
            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("item bilgisi güncellendi");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
