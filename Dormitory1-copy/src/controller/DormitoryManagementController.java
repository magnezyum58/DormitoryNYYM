package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class DormitoryManagementController implements Initializable {

    private int bed;
    protected static int bedSta;
    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    private Button Button7;

    @FXML
    private Button Button8;

    @FXML
    private Button Button9;

    @FXML
    private Button Button10;

    @FXML
    private Button Button11;

    @FXML
    private Button Button12;

    @FXML
    private Button Button13;

    @FXML
    private Button Button14;

    @FXML
    private Button Button15;

    @FXML
    private Button Button16;

    @FXML
    private Button Button17;

    @FXML
    private Button Button18;

    @FXML
    private MenuItem menuButton1;

    @FXML
    private MenuItem menuButton2;

    @FXML
    private MenuItem menuButton3;

    @FXML
    private MenuItem menuButton4;

    @FXML
    private MenuItem menuButton5;

    @FXML
    private MenuItem menuButton6;

    @FXML
    private Label iconLabel;

    @FXML
    private Button Button19;

    @FXML
    private Button Button20;

    @FXML
    private Button Button21;

    @FXML
    private Button Button22;

    @FXML
    private Button Button23;

    @FXML
    private Button Button24;

    @FXML
    private Button Button25;

    @FXML
    private Button Button26;

    @FXML
    private Button Button27;

    @FXML
    private Button Button28;

    @FXML
    private Button Button29;

    @FXML
    private Button Button30;

    @FXML
    private Button backButton;

    @FXML
    void Button1Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 1;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button2Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 2;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button3Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 3;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button4Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 4;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button5Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 5;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button6Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 6;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button7Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 7;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button8Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 8;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button9Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 9;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button10Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 10;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button11(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 11;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button12Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 12;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button13Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 13;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button14Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 14;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button15Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 15;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button16Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 16;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button17Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 17;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button18Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 18;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button19Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 19;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button20Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 20;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button21Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 21;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button22Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 22;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button23Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 23;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button24Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 24;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button25Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 25;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button26Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 26;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button27Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 27;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button28Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 28;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button29Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 29;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void Button30Action(ActionEvent event) throws IOException {
        int bedNumber = bedNumber() + 30;
        DormitoryManagementController.bedSta = bedNumber;
        newFxml();
    }

    @FXML
    void menuButton1Action(ActionEvent event) {
        this.bed = 1;
    }

    @FXML
    void menuButton2Action(ActionEvent event) {
        this.bed = 2;
    }

    @FXML
    void menuButton3Action(ActionEvent event) {
        this.bed = 3;
    }

    @FXML
    void menuButton4Action(ActionEvent event) {
        this.bed = 4;
    }

    @FXML
    void menuButton5Action(ActionEvent event) {
        this.bed = 5;
    }

    @FXML
    void menuButton6Action(ActionEvent event) {
        this.bed = 6;
    }

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FirstFxml.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 750, 425));
    }

    private int bedNumber() {
        return ((this.bed - 1) * 30);
    }


    private void newFxml() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/RoomManagement.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.bed = 1;
    }

}
