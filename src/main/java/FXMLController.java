package main.java;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import main.java.constants.SQLiteDB;

//import static main.java.constants.SQLiteDB.jdbcURL;

/**
 * FXML Controller class
 * @author Villan
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField newUsername;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField existingUsername;

    @FXML
    private TextField existingUserPassword;

    @FXML
    private TabPane authTabPane;

    @FXML
    private Tab loginTab;

    @FXML
    private Tab newUserTab;

    @FXML
    private ColorPicker userColor;

    @FXML
    private Label errorMessageLabelLogin;

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
        String password = newPassword.getText();
        System.out.println(username);

        try {
            Connection connection = DriverManager.getConnection(SQLiteDB.jdbcURL);
            String sql = "SELECT * FROM players WHERE userName = '";
            if (!username.isBlank()) {
                sql = sql + username + "'";

                System.out.println(sql);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                if (result.next()){
                    usernameExistsAlert();

                } else {
                    // SQLite query to create new user with password

                }

            }

        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace();
        }

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

        // Connect to the database
        try {
            Connection connection = DriverManager.getConnection(SQLiteDB.jdbcURL);
            String sql = "SELECT * FROM players WHERE userName = '";
            if (!username.isBlank()) {
                sql = sql + username + "'";

                System.out.println(sql);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                if (result.next()){
                    // Check if password match

                    // load user profile

                    /////////////////// Todo: replace this later
                    String username2 = result.getString("userName");
                    int hp = result.getInt("hp");

                    System.out.println("Username: " + username2 + ", hp: " + hp);
                    ///////////////////

                } else {
                    usernameNonExistentAlert();
                }

            }

        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace();
        }


    }

    /**
     *  Alert user if username already exists
     */
    public void usernameExistsAlert(){

        Alert alert = new Alert(Alert.AlertType.WARNING,"", ButtonType.YES, ButtonType.NO);  //new alert object
        alert.setTitle("Warning!");  //warning box title
        alert.setHeaderText("Username taken!");// Header
        alert.setContentText("Username already exists. Login instead?"); //Description of warning
        alert.getDialogPane().setPrefSize(300, 150); //sets size of alert box

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.out.println("user chose YES");
            authTabPane.getSelectionModel().select(loginTab);
        } else {
            System.out.println("user chose NO or closed the dialog");

        }

    }

    /**
     *  Alert user if username does not exist on login
     */
    public void usernameNonExistentAlert(){

        Alert alert = new Alert(Alert.AlertType.WARNING,"", ButtonType.YES, ButtonType.NO);  //new alert object
        alert.setTitle("Warning!");  //warning box title
        alert.setHeaderText("Username not found!");// Header
        alert.setContentText("Username does not exist. Create new user instead?"); //Discription of warning
        alert.getDialogPane().setPrefSize(300, 150); //sets size of alert box

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.out.println("user chose YES");
            authTabPane.getSelectionModel().select(newUserTab);

        } else {
            System.out.println("user chose NO or closed the dialog");

        }

    }
}