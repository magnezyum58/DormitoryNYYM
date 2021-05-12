package controller;

import static controller.LoginController.p;
import static controller.LoginController.u;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import storage.FirstFxmlStorage;

public class FirstFxmlController implements Initializable {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button studentManagementButton;

    @FXML
    private Button employeeManagementButton;

    @FXML
    private Button inventoryButton;

    @FXML
    private Button dormitoryManagementButton;

    @FXML
    private Pane bottomPanel;

    @FXML
    private Label nameValueLabel;

    @FXML
    private Label authorityValueLabel;

    private FirstFxmlStorage fStorage;

    @FXML
    void dormitoryManagementButtonAction(ActionEvent event) {

    }

    @FXML
    void employeeManagementButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/EmployeeManagement.fxml"));
            Stage window = (Stage) employeeManagementButton.getScene().getWindow();
            window.setScene(new Scene(root, 694, 446));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void inventoryButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Inventory.fxml"));
            Stage window = (Stage) inventoryButton.getScene().getWindow();
            window.setScene(new Scene(root, 728, 502));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void studentManagementButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/StudentManagement.fxml"));
            Stage window = (Stage) studentManagementButton.getScene().getWindow();
            window.setScene(new Scene(root, 813, 511));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//a
        fStorage = new FirstFxmlStorage();
        this.nameValueLabel.setText(this.fStorage.getNameSurname(u, p));
        this.authorityValueLabel.setText("admin");
    }

}
