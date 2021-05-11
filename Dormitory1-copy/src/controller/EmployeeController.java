package controller;

import entity.Employee;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import storage.EmployeeStorage;

public class EmployeeController implements Initializable {

    @FXML
    private TableView<Employee> tableView;

    @FXML
    private TableColumn<Employee, String> id;

    @FXML
    private TableColumn<Employee, String> username;

    @FXML
    private TableColumn<Employee, String> password;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private TableColumn<Employee, String> surname;

    @FXML
    private TableColumn<Employee, String> tcNo;

    @FXML
    private Button backButton;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private TextField idText;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField surnameText;

    @FXML
    private TextField tcNoText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tcNo.setCellValueFactory(new PropertyValueFactory<>("tcNo"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        tableView.setItems(getEmployeeStorage().fillEmployeeList());
    }

    @FXML
    void addButtonAction(ActionEvent event) {
        String name = nameText.getText();
        String surname = surnameText.getText();
        String tcNo = tcNoText.getText();
        String username = usernameText.getText();
        String password = passwordText.getText();

        getEmployeeStorage().userInsert(new Employee(username, password, name, surname, tcNo));
        getEmployeeStorage().fillEmployeeList();
    }

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FirstFxml.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 750, 425));
    }

    @FXML
    void deleteButtonAction(ActionEvent event) {
        getEmployeeStorage().deleteUser(parseInt(idText.getText()));
        getEmployeeStorage().fillEmployeeList();
        idText.clear();
        nameText.clear();
        surnameText.clear();
        tcNoText.clear();
        usernameText.clear();
        passwordText.clear();
    }

    @FXML
    void tableViewAction(Event event) {
        idText.setText(tableView.getSelectionModel().getSelectedItem().getId());
        nameText.setText(tableView.getSelectionModel().getSelectedItem().getName());
        surnameText.setText(tableView.getSelectionModel().getSelectedItem().getSurname());
        tcNoText.setText(tableView.getSelectionModel().getSelectedItem().getTcNo());
        usernameText.setText(tableView.getSelectionModel().getSelectedItem().getUsername());
        passwordText.setText(tableView.getSelectionModel().getSelectedItem().getPassword());
    }

    @FXML
    void updateButtonAction(ActionEvent event) {
        String name = nameText.getText();
        String surname = surnameText.getText();
        String tcNo = tcNoText.getText();
        String username = usernameText.getText();
        String password = passwordText.getText();

        getEmployeeStorage().updateEmployee(parseInt(idText.getText()), new Employee(username, password, name, surname, tcNo));
        getEmployeeStorage().fillEmployeeList();
    }

    private EmployeeStorage employeeStorage;
    private List<Employee> eList;

    public EmployeeStorage getEmployeeStorage() {
        if (employeeStorage == null) {
            this.employeeStorage = new EmployeeStorage();
        }
        return employeeStorage;
    }

    /*public void setEmployeeStorage(EmployeeStorage employeeStorage) {
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
    }*/
}
