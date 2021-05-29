package main.java.swing;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javax.swing.*;
import java.util.Optional;

public class ObjectClicks {

    GameLogic gameLogic;

    public ObjectClicks(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }

    public static void objectClicked(String action, GameLogic gameLogic) {

        switch(action){

            // user room items
            case "rest": {
                // restore currentPlayer hp and mp to max
                int dialogButton = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog (null, "Rest restores hp & mp, clears stats. Rest?","Warning",dialogButton);

                if (dialogButton == JOptionPane.YES_OPTION) {
                    // restore currentUser hp and mp to max based on level
                    // clear stats array
                }

                System.out.println("User is resting");
                break;
            }
            case "storage": {
                System.out.println("opened inventory");
                break;
            }
            case "guidebook": {
                System.out.println("Go to guidebook");
                break;
            }
            case "diary": {
                System.out.println("go to user page");
                break;
            }
            case "go out": {
                // switch scene to town scene
                System.out.println("head to town");
                gameLogic.scenesController.changeToTownScene();
                System.out.println("made it to town");
                break;
            }
            case "inventory": {
                // bring up option for take or store
                System.out.println("open inventory");
                break;
            }

            // town items (double value when buy)
            case "armour": {
                // buy armour only
                // open shop interface for armour
                System.out.println("go to armour shop");
                break;
            }
            case "weapons": {
                // buy weapons only
                // open shop interface for weapons
                System.out.println("visit weapons smith");
                break;
            }
            case "merchant": {
                // buy or sell
                // open option for either buy or sell
                System.out.println("trade with merchant");
                break;
            }
            case "paths": {
                // switch scene to paths scene
                System.out.println("explore paths");
                break;
            }
            case "home": {
                // switch scene to home scene
                System.out.println("go back home");
                gameLogic.scenesController.changeToHomeScene();
                System.out.println("scene changed to home");

                break;
            }

            // fight clicks

            // no item detected
            default:{
                System.out.println("No action matched");
            }
        }
    }

    /**
     *  Alert user resting will restore full health but remove all stats
     */
    private static void restAlert() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION,"", ButtonType.YES, ButtonType.NO);  //new alert object
        alert.setTitle("Rest");  //warning box title
        alert.setHeaderText("Rest");// Header
        alert.setContentText("Resting will reset all stats and restore full hp and mp. Proceed?"); //Description of warning
        alert.getDialogPane().setPrefSize(300, 150); //sets size of alert box

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.out.println("user chose YES");
        } else {
            System.out.println("user chose NO or closed the dialog");

        }

    }


}
