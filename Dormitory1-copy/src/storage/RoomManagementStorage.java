package storage;

import entity.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import static util.DatabaseConnect.getDbConnect;

public class RoomManagementStorage {

    Connection con;

    public boolean roomControl(int bedNumber) {
        con = getDbConnect().connect();
        int full = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Bed");
            while (rs.next()) {
                if (rs.getInt("idBed") == bedNumber) {
                    full = rs.getInt("full");
                }      
            }
            if (full != 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return true;
        }
        return true;
    }

    public String studentId(int bedNumber) {
        con = getDbConnect().connect();
        String studentNumber = null;
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Bed");
            while (rs.next()) {
                if (bedNumber == rs.getInt("idBed")) {
                    studentNumber = rs.getString("studentId");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentNumber;
    }

    public String getNameSurname(int bedNumber) {
        String studentNumber = this.studentId(bedNumber);
        con = getDbConnect().connect();
        String nameSurname = null;
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Student");
            while (rs.next()) {
                if (studentNumber.equals(rs.getString("studentNumber"))) {
                    nameSurname = rs.getString("name") + " " + rs.getString("surname");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nameSurname;
    }

    public String getTcNo(int bedNumber) {
        String studentNumber = this.studentId(bedNumber);
        con = getDbConnect().connect();
        String tcNo = null;
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Student");
            while (rs.next()) {
                if (studentNumber.equals(rs.getString("studentNumber"))) {
                    tcNo = rs.getString("tcNo");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tcNo;
    }

    protected void updateBed(Student stu) {
        con = getDbConnect().connect();
        try {
            String sql = "UPDATE Bed set studentId='" + stu.getStudentNumber() + "',full='1' WHERE id=('" + stu.getBedNumber() + "')";
            Statement statement = con.createStatement();
            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("Yatak bilgisi güncellendi");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void deleteBed(Student stu) {
        con = getDbConnect().connect();
        try {
            String sql = "UPDATE Bed set studentId='null',full='0' WHERE id=('" + stu.getBedNumber() + "')";
            Statement statement = con.createStatement();
            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("Yatak bilgisi güncellendi");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
