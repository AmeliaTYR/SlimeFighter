package main.java;


import java.awt.*;
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
import javafx.scene.control.ColorPicker;
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

    @FXML
    private TextField existingUsername;

    @FXML
    private ColorPicker userColor;

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

        } else {
            // else procceed to create new user

            // temporary user creation algo
            Main.currentUser.setUsername(username);

            // change scene to current point in game



        }


    }

    @FXML
    protected void handleUserLoginButtonAction(ActionEvent event) {
        System.out.println("User login");

        String username = existingUsername.getText();
        System.out.println(username);

        // check if user name in list of users


        // if in then load user profile
        // temporary user load

        // else have alert that user does not exist, prompt to create new user

        // other check for password validation


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

    /**
     *  Alert user if username does not exist on login
     */
    public void usernameNonExistantAlert(){

        Alert alert = new Alert(Alert.AlertType.WARNING,"", ButtonType.YES, ButtonType.NO);  //new alert object
        alert.setTitle("Warning!");  //warning box title
        alert.setHeaderText("Username not found!");// Header
        alert.setContentText("Username does not exist. Create new user instead?"); //Discription of warning
        alert.getDialogPane().setPrefSize(300, 150); //sets size of alert box

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.out.println("user chose YES");
        } else {
            System.out.println("user chose NO or closed the dialog");

        }

    }
}