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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import storage.RoomManagementStorage;

public class RoomManagementController implements Initializable {

    @FXML
    private Pane bottomPane1;
    @FXML
    private Pane bottomPane2;
    @FXML
    private Pane bottomPane3;
    @FXML
    private Pane bottomPane4;
    @FXML
    private Label roomNumberLabel;

    @FXML
    private TextField nameSurnameText1;

    @FXML
    private TextField tcNoText1;

    @FXML
    private TextField studentNumberText1;

    @FXML
    private TextField nameSurnameText2;

    @FXML
    private TextField tcNoText2;

    @FXML
    private TextField studentNumberText2;

    @FXML
    private TextField nameSurnameText3;

    @FXML
    private TextField tcNoText3;

    @FXML
    private TextField studentNumberText3;

    @FXML
    private TextField nameSurnameText4;

    @FXML
    private TextField tcNoText4;

    @FXML
    private TextField studentNumberText4;

    @FXML
    private Label bedNumber1;

    @FXML
    private Label bedNumber2;

    @FXML
    private Label bedNumber3;

    @FXML
    private Label bedNumber4;

    @FXML
    private Button backButton;
    RoomManagementStorage mg;

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/DormitoryManagement.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 750, 425));
    }

    private void view() {
        int roomNumber = DormitoryManagementController.bedSta;
        int bed1 = ((roomNumber - 1) * 4) + 1;
        int bed2 = bed1 + 1;
        int bed3 = bed1 + 2;
        int bed4 = bed1 + 3;
        this.bedNumber1.setText("    " + bed1);
        this.bedNumber2.setText("    " + bed2);
        this.bedNumber3.setText("    " + bed3);
        this.bedNumber4.setText("    " + bed4);
        this.roomNumberLabel.setText("      " + roomNumber);
    }

    public void visibility() {
        mg=new RoomManagementStorage();
        int roomNumber = DormitoryManagementController.bedSta;
        int bed1 = ((roomNumber - 1) * 4) + 1;
        int bed2 = bed1 + 1;
        int bed3 = bed1 + 2;
        int bed4 = bed1 + 3;
        if (this.mg.roomControl(bed1)) {
            this.nameSurnameText1.setVisible(false);
            this.tcNoText1.setVisible(false);
            this.studentNumberText1.setVisible(false);
            
        } else {
            this.nameSurnameText1.setText("Name: "+this.mg.getNameSurname(bed1));
            this.studentNumberText1.setText("Student No: "+this.mg.studentId(bed1));
            this.tcNoText1.setText("Tc No: "+this.mg.getTcNo(bed1));
            this.nameSurnameText1.setEditable(false);
            this.tcNoText1.setEditable(false);
            this.studentNumberText1.setEditable(false);
        }
        if (this.mg.roomControl(bed2)) {
            this.nameSurnameText2.setVisible(false);
            this.tcNoText2.setVisible(false);
            this.studentNumberText2.setVisible(false);
        } else {
            this.nameSurnameText2.setText("Name: "+this.mg.getNameSurname(bed2));
            this.studentNumberText2.setText("Student No: "+this.mg.studentId(bed2));
            this.tcNoText2.setText("Tc No: "+this.mg.getTcNo(bed2));
            this.nameSurnameText2.setEditable(false);
            this.tcNoText2.setEditable(false);
            this.studentNumberText2.setEditable(false);
        }
        if (this.mg.roomControl(bed3)) {
            this.nameSurnameText3.setVisible(false);
            this.tcNoText3.setVisible(false);
            this.studentNumberText3.setVisible(false);
        } else {
            this.nameSurnameText3.setText("Name: "+this.mg.getNameSurname(bed3));
            this.studentNumberText3.setText("Student No: "+this.mg.studentId(bed3));
            this.tcNoText3.setText("Tc No: "+this.mg.getTcNo(bed3));
            this.nameSurnameText3.setEditable(false);
            this.tcNoText3.setEditable(false);
            this.studentNumberText3.setEditable(false);
        }
        if (this.mg.roomControl(bed4)) {
            this.nameSurnameText4.setVisible(false);
            this.tcNoText4.setVisible(false);
            this.studentNumberText4.setVisible(false);
        } else {
            this.nameSurnameText4.setText("Name: "+this.mg.getNameSurname(bed4));
            this.studentNumberText4.setText("Student No: "+this.mg.studentId(bed4));
            this.tcNoText4.setText("Tc No: "+this.mg.getTcNo(bed4));
            this.nameSurnameText4.setEditable(false);
            this.tcNoText4.setEditable(false);
            this.studentNumberText4.setEditable(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         visibility();
        view();
    }

}
