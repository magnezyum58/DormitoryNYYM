package entity;

public class Employee extends Human {

    private String username;
    private String password;
    private final int employeeId;

    public Employee(String username, String password, int employeeId,String name,String surname,String tcNo) {
        this.setName(name);
        this.setSurname(surname);
        this.setTcNo(tcNo);
        this.username = username;
        this.password = password;
        this.employeeId = employeeId;
    }
    
    public String getUsername() {
        return username;
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

    public int getEmployeeId() {
        return employeeId;
    }

}
