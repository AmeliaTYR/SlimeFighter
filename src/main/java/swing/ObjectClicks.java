package main.java.swing;

import main.java.Main;
import main.java.items.Inventory;
import main.java.items.StatusEffectList;

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
                dialogButton = JOptionPane.showConfirmDialog(null, "Rest restores hp & mp AND clears stats. Rest?","Warning", dialogButton);

                if (dialogButton == JOptionPane.YES_OPTION) {
                    // restore currentUser hp and mp to max based on level
                    // clear stats array
                    System.out.println("user choose to rest");
                    StatusEffectList.restClearAllStats();
                } else {
                    System.out.println("user did not rest");
                }

                break;
            }
            case "storage": {
                System.out.println("opened storage");
                break;
            }
            case "guidebook": {
                System.out.println("Go to guidebook");
                break;
            }
            case "diary": {
                System.out.println("go to in game stats page");
                // todo: save user basic data (eg level, exp, coins etc) to currentUser
                Main.currentUser.getPlayerDataFromDB();

                // todo: save user statusEffects data
                StatusEffectList.getAllEffectsFromSaveData();

                // todo: save user inventory
                Inventory.getAllItemsFromDB();

                // todo: save user storage

                // todo:  save user gear

                // todo: create alert to show that save was complete
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


}
