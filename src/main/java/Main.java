package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.java.characters.Player;

import java.io.File;

public class Main extends Application {

    public static Player currentUser = new Player();

    @Override
    public void start(Stage loginStage) throws Exception{
//        Image image = new Image(new File("SlimeFighter.ico").toURI().toString());
        Image image = new Image("./main/resources/images/SlimeFighter.jpg");

        loginStage.getIcons().add(image);

        for (int i=0; i<100; i++){
            System.out.println("hello " + i);
        }

        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/login.fxml"));

        loginStage.setTitle("Slime Fighter");
        loginStage.setScene(new Scene(root, 600, 400));

        loginStage.show();

    }


}
