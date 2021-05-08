package controller;

import entity.Student;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
}
