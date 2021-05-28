package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import main.java.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class userPageController implements Initializable {
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



}
