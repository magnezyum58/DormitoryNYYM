package entity;

public class Employee extends Human {

    private String username;
    private String password;
    private String id;

    public Employee(String id, String username, String password, String name, String surname, String tcNo) {
        this.setName(name);
        this.setSurname(surname);
        this.setTcNo(tcNo);
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public Employee(String username, String password, String name, String surname, String tcNo) {
        this.setName(name);
        this.setSurname(surname);
        this.setTcNo(tcNo);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeId() {
        return id;
    }

}
