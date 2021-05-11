package controller;

import entity.Student;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
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
import storage.StudentStorage;

public class StudentManagementController implements Initializable {

    @FXML
    private TableView<Student> tableView;
    
    @FXML
    private TableColumn<Student, String> id;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> surname;

    @FXML
    private TableColumn<Student, String> bedNo;

    @FXML
    private TableColumn<Student, String> roomNo;

    @FXML
    private TableColumn<Student, String> studentNo;

    @FXML
    private TableColumn<Student, String> tcNo;
    
    @FXML
    private Button backButton;
    
    @FXML
    private TextField nameText;

    @FXML
    private TextField surnameText;

    @FXML
    private TextField tcNoText;

    @FXML
    private TextField studentNoText;

    @FXML
    private TextField bedNoText;

    @FXML
    private TextField roomText;

    @FXML
    private TextField idText;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;
    
    private StudentStorage studentStorage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tcNo.setCellValueFactory(new PropertyValueFactory<>("tcNo"));
        roomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        bedNo.setCellValueFactory(new PropertyValueFactory<>("bedNumber"));
        studentNo.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        tableView.setItems(getStudentStorage().fillStudentList());
    }    
    
    @FXML
    void tableViewAction(Event event) {
        idText.setText(tableView.getSelectionModel().getSelectedItem().getId());
        nameText.setText(tableView.getSelectionModel().getSelectedItem().getName());
        surnameText.setText(tableView.getSelectionModel().getSelectedItem().getSurname());
        tcNoText.setText(tableView.getSelectionModel().getSelectedItem().getTcNo());
        studentNoText.setText(tableView.getSelectionModel().getSelectedItem().getStudentNumber());
        roomText.setText(tableView.getSelectionModel().getSelectedItem().getRoomNumber());
        bedNoText.setText(tableView.getSelectionModel().getSelectedItem().getBedNumber());
    }

    private StudentStorage getStudentStorage() {
        if(studentStorage==null){
            studentStorage=new StudentStorage();
        }
        return studentStorage;
    }
   
    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FirstFxml.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 750, 425));
    }
    
    @FXML
    void addButtonAction(ActionEvent event) {
        String name=nameText.getText();
        String surname=surnameText.getText();
        String tcNo=tcNoText.getText();
        String roomNo=roomText.getText();
        String bedNo=bedNoText.getText();
        String studentNo=studentNoText.getText();
        
        getStudentStorage().insertItem(new Student(name,surname,tcNo,studentNo,roomNo,bedNo));
        getStudentStorage().fillStudentList();
    }

    @FXML
    void deleteButtonAction(ActionEvent event) {
        getStudentStorage().deleteItem(parseInt(idText.getText()));
        getStudentStorage().fillStudentList();
        idText.clear();
        nameText.clear();
        surnameText.clear();
        tcNoText.clear();
        roomText.clear();
        bedNoText.clear();
        studentNoText.clear();
    }

    @FXML
    void updateButtonAction(ActionEvent event) {
        String name=nameText.getText();
        String surname=surnameText.getText();
        String tcNo=tcNoText.getText();
        String roomNo=roomText.getText();
        String bedNo=bedNoText.getText();
        String studentNo=studentNoText.getText();
        
        getStudentStorage().updateItem(parseInt(idText.getText()),new Student(name,surname,tcNo,studentNo,roomNo,bedNo));
        getStudentStorage().fillStudentList();
    }
}
