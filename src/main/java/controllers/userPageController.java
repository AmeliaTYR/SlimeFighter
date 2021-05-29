package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.java.Main;
import main.java.swing.GameLogic;

import javax.swing.*;
import java.awt.*;
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
        // Todo: add user Profile pic code

        // get user data
        usernameProfileDisplay.setText(Main.currentUser.getUsername());
        levelNumLabel.setText(Integer.toString(Main.currentUser.getLevel()));
        expNumLabel.setText(Integer.toString(Main.currentUser.getExp()));
        coinsNumLabel.setText(Integer.toString(Main.currentUser.getCoins()));
        hpNumLabel.setText(Integer.toString(Main.currentUser.getHp()));
        mpNumLabel.setText(Integer.toString(Main.currentUser.getMp()));
        defNumLabel.setText(Integer.toString(Main.currentUser.getDef()));
    }


    @FXML
    protected void handleResumeGameButtonAction() {
        Stage stage = (Stage) rtnToGameBtn.getScene().getWindow();
        stage.hide();

        // go to room scene
        gameLogic = new GameLogic();

    }



}
