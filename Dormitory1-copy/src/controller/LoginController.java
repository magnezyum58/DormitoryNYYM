package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import storage.LoginStorage;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Pane bottomPane;

    @FXML
    private Label iconLabel;

    @FXML
    private TextField usernameText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button signInButton;

    @FXML
    private Label usernameIcon;

    @FXML
    public Label passwordIcon;

    protected static String u;
    protected static String p;

    @FXML
    void signInButtonAction(ActionEvent event) throws IOException {
        LoginStorage loginStorage = new LoginStorage();
        if (loginStorage.isUserExist(usernameText.getText(), passwordText.getText())) {
            u = usernameText.getText();
            p = passwordText.getText();
            Parent root = FXMLLoader.load(getClass().getResource("/view/FirstFxml.fxml"));
            Stage window = (Stage) signInButton.getScene().getWindow();
            window.setScene(new Scene(root, 750, 425));
        } else {
            usernameText.setText("");
            passwordText.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
