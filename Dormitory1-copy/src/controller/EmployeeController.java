package controller;

import entity.Employee;
import java.util.ArrayList;
import java.util.List;
import storage.EmployeeStorage;

public class EmployeeController {

    private EmployeeStorage employeeStorage;
    private List<Employee> eList;

    public EmployeeStorage getEmployeeStorage() {
        if (employeeStorage == null) {
            this.employeeStorage = new EmployeeStorage();
        }
        return employeeStorage;
    }

    public void setEmployeeStorage(EmployeeStorage employeeStorage) {
        this.employeeStorage = employeeStorage;
    }

    public List<Employee> geteList() {
        if (eList == null) {
            this.eList = new ArrayList<Employee>();
        }
        return eList;
    }

    public void seteList(List<Employee> eList) {
        this.eList = eList;
    }

    public void employeeAdd(String username, String password, int employeeId, String name, String surname, String tcNo) {
        this.getEmployeeStorage().userInsert(new Employee(username, password, employeeId, name, surname, tcNo));
    }

    public List<Employee> userRead() {
        this.seteList(this.getEmployeeStorage().userRead());
        return this.geteList();
    }

}
