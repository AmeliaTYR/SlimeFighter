package main.java.fxmlControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.java.Main;
import main.java.swing.GameLogic;

import java.net.URL;
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
    protected void handleSaveButtonAction() {
        // todo: save user basic data (eg level, exp, coins etc)

        // todo: save user statusEffects data

        // todo: save user inventory

        // todo: save user storage

        // todo:  save user gear

        // todo: create alert to show that save was complete

    }



}
