package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.Main;
import main.java.constants.SQLiteDB;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 * @author Villan
 */
public class loginFXMLController implements Initializable {

    @FXML
    private TextField newUsername;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField existingUsername;

    @FXML
    private TextField existingUserPassword;
    // Todo: Add password checks

    @FXML
    private TabPane authTabPane;

    @FXML
    private Tab loginTab;

    @FXML
    private Tab newUserTab;

    @FXML
    private Button userLoginButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Handle checks and login for create new user
     */
    @FXML
    protected void handleCreateUserButtonAction() {
        String username = newUsername.getText();
        String password = newPassword.getText();

        if (username.isBlank()) {
            usernameFieldBlankAlert();
            return;
        }

        // Todo: add password check


        try {
            Connection connection = DriverManager.getConnection(SQLiteDB.jdbcURL);
            String sql = "SELECT * FROM players WHERE userName = '";
            if (!username.isBlank()) {
                sql = sql + username + "'";

                System.out.println(sql);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                if (result.next()){
                    usernameExistsAlert(username);

                } else {
                    // SQLite query to create new user with password
                    Statement newUserStatement = connection.createStatement();
                    String newUserSql = "INSERT INTO players (userName, passWord) Values('"
                            + username + "', '" + password + "')";
                    newUserStatement.executeUpdate(newUserSql);

                    // set main user
                    Main.currentUser.setUsername(username);

                    // go to starting page

                    System.out.println("closing stage");

                    // change stage
                    Stage stage = (Stage) userLoginButton.getScene().getWindow();
                    stage.close();

                }

            }

        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace();
        }

    }

    /**
     * Handle checks and login when user logs in
     */
    @FXML
    protected void handleUserLoginButtonAction() {
        String username = existingUsername.getText();

        if (username.isBlank()) {
            usernameFieldBlankAlert();
            return;
        }

        // Todo: add password check

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
                    Main.currentUser.setUsername(username);
                    Main.currentUser.setHp(result.getInt("hp"));
                    Main.currentUser.setMp(result.getInt("mp"));
                    Main.currentUser.setExp(result.getInt("Exp"));
                    Main.currentUser.setLevel(result.getInt("level"));
                    Main.currentUser.setCoins(result.getInt("coins"));
                    Main.currentUser.setLocation(result.getString("location"));
                    Main.currentUser.setAtk(result.getInt("atk"));
                    Main.currentUser.setDef(result.getInt("def"));


                    System.out.println("Username: " + Main.currentUser.getUsername() + ", atk: " + Main.currentUser.getAtk());

                    // go to userPage
                    System.out.println("changing stage");

                    // change stage
                    Stage stage = (Stage) userLoginButton.getScene().getWindow();

                    // open inventory stage
                    // use login.fxml
                    Parent root = FXMLLoader.load(getClass().getResource("../../resources/fxml/userPage.fxml"));

                    stage.setTitle("Slime Fighter");
                    stage.setScene(new Scene(root, 600, 400));

                } else {
                    usernameNonExistentAlert(username);
                }

            }

        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Cannot load userPage.fxml");
            e.printStackTrace();
        }
    }

    /**
     *  Alert user if username already exists
     */
    public void usernameExistsAlert(String username){

        Alert alert = new Alert(Alert.AlertType.WARNING,"", ButtonType.YES, ButtonType.NO);  //new alert object
        alert.setTitle("Warning!");  //warning box title
        alert.setHeaderText("Username taken!");// Header
        alert.setContentText("Username already exists. Login instead?"); //Description of warning
        alert.getDialogPane().setPrefSize(300, 150); //sets size of alert box

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.out.println("user chose YES");
            authTabPane.getSelectionModel().select(loginTab);
            existingUsername.setText(username);
        } else {
            System.out.println("user chose NO or closed the dialog");

        }

    }

    /**
     *  Alert user if username does not exist on login
     */
    public void usernameNonExistentAlert(String username){

        Alert alert = new Alert(Alert.AlertType.WARNING,"", ButtonType.YES, ButtonType.NO);  //new alert object
        alert.setTitle("Warning!");  //warning box title
        alert.setHeaderText("Username not found!");// Header
        alert.setContentText("Username does not exist. Create new user instead?"); //Description of warning
        alert.getDialogPane().setPrefSize(300, 150); //sets size of alert box

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.out.println("user chose YES");
            authTabPane.getSelectionModel().select(newUserTab);
            newUsername.setText(username);
        } else {
            System.out.println("user chose NO or closed the dialog");

        }

    }

    /**
     * Show alert when username field is blank
     */
    private void usernameFieldBlankAlert() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Username field empty");// Header
        alert.setContentText("Please enter a username"); //Description of warning
        alert.show();
    }
}

