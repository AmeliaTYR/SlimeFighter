package main.java;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 * @author Villan
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField newUsername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    protected void handleCreateUserButtonAction(ActionEvent event) {
        System.out.println("Create new user:");
        String username = newUsername.getText();
        System.out.println(username);

        // check if username already exists
        if (username.equals("ames")) {
            usernameExistsAlert();

        }

        // else procceed to create new user
    }

    @FXML
    protected void handleUserLoginButtonAction(ActionEvent event) {
        System.out.println("User login");
    }

    /**
     *  Alert user if username already exists
     */
    public void usernameExistsAlert(){

        Alert alert = new Alert(Alert.AlertType.WARNING,"", ButtonType.YES, ButtonType.NO);  //new alert object
        alert.setTitle("Warning!");  //warning box title
        alert.setHeaderText("Username taken!");// Header
        alert.setContentText("Username already exists. Login instead?"); //Discription of warning
        alert.getDialogPane().setPrefSize(300, 150); //sets size of alert box

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.out.println("user chose YES");
        } else {
            System.out.println("user chose NO or closed the dialog");

        }

    }
}