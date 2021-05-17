package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.characters.Player;

//import java.io.IOException;
//import java.util.Scanner;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//import javafx.scene.layout.StackPane;
//
//import javafx.scene.paint.Color;

public class Main extends Application {

    public static Player currentUser = new Player();

    @Override
    public void start(Stage loginStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/login.fxml"));
        loginStage.setTitle("Slime Fighter");
        loginStage.setScene(new Scene(root, 600, 400));
        loginStage.show();

    }


}
