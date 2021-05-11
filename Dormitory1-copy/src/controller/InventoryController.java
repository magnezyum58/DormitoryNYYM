package controller;


import entity.Inventory;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import storage.InventoryStorage;

public class InventoryController implements Initializable {

    @FXML
    private TableView<Inventory> tableView;

    @FXML
    private TableColumn<Inventory, String> id;

    @FXML
    private TableColumn<Inventory, String> isim;

    @FXML
    private TableColumn<Inventory, String> adet;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField pieceTextField;

    @FXML
    private TextField idTextField;
    
    @FXML
    private Label iconLabel;
    private InventoryStorage inventoryStorage;

    public InventoryStorage getInventoryStorage() {
        if(inventoryStorage==null){
            inventoryStorage = new InventoryStorage();
        }
        return inventoryStorage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        isim.setCellValueFactory(new PropertyValueFactory<>("name"));
        adet.setCellValueFactory(new PropertyValueFactory<>("piece"));
        tableView.setItems(getInventoryStorage().fillInventoryList());

    }

    @FXML
    void tableViewAction(Event event) {
        idTextField.setText(tableView.getSelectionModel().getSelectedItem().getId());
        nameTextField.setText(tableView.getSelectionModel().getSelectedItem().getName());
        pieceTextField.setText(tableView.getSelectionModel().getSelectedItem().getPiece());
    }

    @FXML
    void addButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        String piece = pieceTextField.getText();

        getInventoryStorage().insertItem(new Inventory(name, piece));
        getInventoryStorage().fillInventoryList();
    }

    @FXML
    void deleteButtonAction(ActionEvent event) {
        getInventoryStorage().deleteItem(parseInt(idTextField.getText()));
        getInventoryStorage().fillInventoryList();
        idTextField.clear();
        nameTextField.clear();
        pieceTextField.clear();
    }

    @FXML
    void updateButtonAction(ActionEvent event) {
        String name=nameTextField.getText();
        String piece=pieceTextField.getText();
        
        getInventoryStorage().updateItem(parseInt(idTextField.getText()),new Inventory(name,piece));
        getInventoryStorage().fillInventoryList();
    }

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FirstFxml.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 750, 425));
    }

}
