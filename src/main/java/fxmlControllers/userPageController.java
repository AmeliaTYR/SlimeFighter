package main.java.fxmlControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.java.Main;
import main.java.swing.GameLogic;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class userPageController implements Initializable {
    public GameLogic gameLogic;

    @FXML
    private Label levelNumLabel;

    @FXML
    private Label expNumLabel;

    @FXML
    private Label coinsNumLabel;
    
    @FXML
    private Label usernameProfileDisplay;

    @FXML
    private Label hpNumLabel;

    @FXML
    private Label mpNumLabel;

    @FXML
    private Label defNumLabel;

    @FXML
    private Button rtnToGameBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Todo: add change user Profile pic code

        // get user data
        usernameProfileDisplay.setText(Main.currentUser.getUsername());
        levelNumLabel.setText(Integer.toString(Main.currentUser.getLevel()));
        expNumLabel.setText(Integer.toString(Main.currentUser.getExp()));
        coinsNumLabel.setText(Integer.toString(Main.currentUser.getCoins()));
        hpNumLabel.setText(Integer.toString(Main.currentUser.getHp()));
        mpNumLabel.setText(Integer.toString(Main.currentUser.getMp()));
        defNumLabel.setText(Integer.toString(Main.currentUser.getDef()));

        // todo: load user stat data

        // todo: load user gear, inventory and storage into array lists
            // make query
            // convert for item in list put in to array list using the class
    }


    @FXML
    protected void handleResumeGameButtonAction() {
        Stage currentStage = (Stage) rtnToGameBtn.getScene().getWindow();
        currentStage.hide();

        // go to room scene
        gameLogic = new GameLogic();

    }

    @FXML
    protected void handleDeleteProfileButtonAction() {
        // show delete confirmation alert


    }


    /**
     *  delete confirmation alert
     */
    public void usernameExistsAlert(String username){

        Alert alert = new Alert(Alert.AlertType.WARNING,"", ButtonType.YES, ButtonType.NO);  //new alert object
        alert.setTitle("Warning!");  //warning box title
        alert.setHeaderText("Delete profile?");// Header
        alert.setContentText("This action cannot be undone!"); //Description of warning
        alert.getDialogPane().setPrefSize(300, 150); //sets size of alert box

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.out.println("user chose to delete profile");
            // sql query to delete all user data
            // todo: delete user basic data (eg level, exp, coins etc)

            // todo: delete user statusEffects data

            // todo: delete user inventory

            // todo: delete user storage

            // todo: delete user gear

            // todo: create alert to show that delete was complete (close app on alert close)

            System.out.println("Deletion complete");

        } else {
            System.out.println("user chose cancel deletion. phew");

        }

    }



}
