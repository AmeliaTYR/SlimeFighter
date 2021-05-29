package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.java.characters.Player;

public class Main extends Application {

    public static Player currentUser = new Player();

    @Override
    public void start(Stage stage) throws Exception{

        // get image for app icon
        Image image = new Image("./main/resources/images/SlimeFighterTransparent.png");

        stage.getIcons().add(image);

        // use login.fxml
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/login.fxml"));

        stage.setTitle("Slime Fighter");
        stage.setScene(new Scene(root, 600, 400));

        stage.show();

    }


}
