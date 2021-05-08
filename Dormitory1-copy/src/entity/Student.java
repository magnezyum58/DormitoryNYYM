package entity;

public class Student extends Human {

    private String id, studentNumber, roomNumber, bedNumber;

    public Student(String id, String name, String surname, String tcNo, String studentNumber, String roomNumber, String bedNumber) {
        this.bedNumber = bedNumber;
        this.roomNumber = roomNumber;
        this.studentNumber = studentNumber;
        this.id = id;
        this.setName(name);
        this.setSurname(surname);
        this.setTcNo(tcNo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

}
